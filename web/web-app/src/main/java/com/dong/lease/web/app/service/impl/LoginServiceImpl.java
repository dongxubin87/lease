package com.dong.lease.web.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dong.lease.common.constant.RedisConstant;
import com.dong.lease.common.exception.LeaseException;
import com.dong.lease.common.result.ResultCodeEnum;
import com.dong.lease.common.utils.CodeUtil;
import com.dong.lease.common.utils.JwtUtil;
import com.dong.lease.model.entity.UserInfo;
import com.dong.lease.model.enums.BaseStatus;
import com.dong.lease.web.app.service.LoginService;
import com.dong.lease.web.app.service.SmsService;
import com.dong.lease.web.app.service.UserInfoService;
import com.dong.lease.web.app.vo.user.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SmsService smsService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public void getCode(String phone) {

        // 1. Check if phone number is empty
        if (!StringUtils.hasText(phone)) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_PHONE_EMPTY);
        }

        // 2. Check whether Redis already contains this phone key
        String key = RedisConstant.APP_LOGIN_PREFIX + phone;
        boolean hasKey = redisTemplate.hasKey(key);

        if (hasKey) {
            // If exists, check remaining TTL
            Long expire = redisTemplate.getExpire(key, TimeUnit.SECONDS);

            if (RedisConstant.APP_LOGIN_CODE_TTL_SEC - expire
                    < RedisConstant.APP_LOGIN_CODE_RESEND_TIME_SEC) {
                // If resend interval is too short, reject request
                throw new LeaseException(ResultCodeEnum.APP_SEND_SMS_TOO_OFTEN);
            }
        }

        // 3. Send SMS and store verification code in Redis
        // String verifyCode = CodeUtil.getVerifyCode(6);
        String verifyCode = "123456";
        smsService.sendCode(phone, verifyCode);

        redisTemplate.opsForValue().set(
                key,
                verifyCode,
                RedisConstant.APP_LOGIN_CODE_TTL_SEC,
                TimeUnit.SECONDS
        );
    }

    @Override
    public String login(LoginVo loginVo) {
        // 1. Check if phone number and verification code are empty
        if (!StringUtils.hasText(loginVo.getPhone())) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_PHONE_EMPTY);
        }

        if (!StringUtils.hasText(loginVo.getCode())) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_EMPTY);
        }

// 2. Validate verification code
        String key = RedisConstant.APP_LOGIN_PREFIX + loginVo.getPhone();
        String code = redisTemplate.opsForValue().get(key);

        if (code == null) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_EXPIRED);
        }

        if (!code.equals(loginVo.getCode())) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_ERROR);
        }

// 3. Check if user exists; if not, register (create user)
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getPhone, loginVo.getPhone());

        UserInfo userInfo = userInfoService.getOne(queryWrapper);

        if (userInfo == null) {
            userInfo = new UserInfo();
            userInfo.setPhone(loginVo.getPhone());
            userInfo.setStatus(BaseStatus.ENABLE);
            userInfo.setNickname("User-" + loginVo.getPhone());
            userInfoService.save(userInfo);
        }

// 4. Check if user is disabled
        if (userInfo.getStatus().equals(BaseStatus.DISABLE)) {
            throw new LeaseException(ResultCodeEnum.APP_ACCOUNT_DISABLED_ERROR);
        }

// 5. Generate and return token
        return JwtUtil.createToken(userInfo.getId(), loginVo.getPhone());
    }
}
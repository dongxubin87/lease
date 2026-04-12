package com.dong.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dong.lease.model.entity.UserInfo;
import com.dong.lease.web.admin.service.UserInfoService;
import com.dong.lease.web.admin.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}





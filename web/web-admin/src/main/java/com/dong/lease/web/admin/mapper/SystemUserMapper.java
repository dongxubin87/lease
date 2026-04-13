package com.dong.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dong.lease.model.entity.SystemUser;
import com.dong.lease.web.admin.vo.system.user.SystemUserItemVo;
import com.dong.lease.web.admin.vo.system.user.SystemUserQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface SystemUserMapper extends BaseMapper<SystemUser> {

    IPage<SystemUserItemVo> pageSystemUserByQuery(IPage<SystemUser> page, SystemUserQueryVo queryVo);

    SystemUser selectOneByUsername(String username);
}





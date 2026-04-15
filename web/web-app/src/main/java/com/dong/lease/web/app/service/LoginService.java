package com.dong.lease.web.app.service;

import com.dong.lease.web.app.vo.user.LoginVo;

public interface LoginService {
    void getCode(String phone);

    String login(LoginVo loginVo);
}

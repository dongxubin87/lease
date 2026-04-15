package com.dong.lease.web.app.controller.login;

import com.dong.lease.common.result.Result;
import com.dong.lease.web.app.service.LoginService;
import com.dong.lease.web.app.vo.user.LoginVo;
import com.dong.lease.web.app.vo.user.UserInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Login Management")
@RestController
@RequestMapping("/app/")
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping("login/getCode")
    @Operation(summary = "Get SMS verification code")
    public Result getCode(@RequestParam String phone) {
        service.getCode(phone);
        return Result.ok();
    }

    @PostMapping("login")
    @Operation(summary = "Login")
    public Result<String> login(@RequestBody LoginVo loginVo) {
        String token = service.login(loginVo);
        return Result.ok(token);
    }

    @GetMapping("info")
    @Operation(summary = "Get logged-in user information")
    public Result<UserInfoVo> info() {
        return Result.ok();
    }
}
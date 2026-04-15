package com.dong.lease.web.app.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "APP Login Object")
public class LoginVo {

    @Schema(description = "Phone number")
    private String phone;

    @Schema(description = "SMS verification code")
    private String code;
}
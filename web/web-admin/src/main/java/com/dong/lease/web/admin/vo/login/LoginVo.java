package com.dong.lease.web.admin.vo.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Backend System Login Information")
public class LoginVo {

    @Schema(description = "Username")
    private String username;

    @Schema(description = "Password")
    private String password;

    @Schema(description = "Captcha key")
    private String captchaKey;

    @Schema(description = "Captcha code")
    private String captchaCode;
}
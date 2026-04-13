package com.dong.lease.web.admin.vo.system.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Employee Basic Information")
@Data
public class SystemUserInfoVo {

    @Schema(description = "User name")
    private String name;

    @Schema(description = "User avatar URL")
    private String avatarUrl;

}
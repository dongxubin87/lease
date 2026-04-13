package com.dong.lease.web.admin.vo.user;

import com.dong.lease.model.enums.BaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "User Information Query Object")
@Data
public class UserInfoQueryVo {

    @Schema(description = "User phone number")
    private String phone;

    @Schema(description = "User account status")
    private BaseStatus status;
}
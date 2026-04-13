package com.dong.lease.model.entity;

import com.dong.lease.model.enums.BaseStatus;
import com.dong.lease.model.enums.SystemUserType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Employee Information")
@TableName(value = "system_user")
@Data
public class SystemUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Username")
    @TableField(value = "username")
    private String username;

    @Schema(description = "Password")
    @TableField(value = "password", select = false)
    private String password;

    @Schema(description = "Name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "User type")
    @TableField(value = "type")
    private SystemUserType type;

    @Schema(description = "Phone number")
    @TableField(value = "phone")
    private String phone;

    @Schema(description = "Avatar URL")
    @TableField(value = "avatar_url")
    private String avatarUrl;

    @Schema(description = "Additional information")
    @TableField(value = "additional_info")
    private String additionalInfo;

    @Schema(description = "Post ID")
    @TableField(value = "post_id")
    private Long postId;

    @Schema(description = "Account status")
    @TableField(value = "status")
    private BaseStatus status;

}
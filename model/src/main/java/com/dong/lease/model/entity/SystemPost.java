package com.dong.lease.model.entity;

import com.dong.lease.model.enums.BaseStatus;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@TableName(value = "system_post")
@Data
public class SystemPost extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Position code")
    @TableField(value = "code")
    private String postCode;

    @Schema(description = "Position name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Position description")
    @TableField(value = "description")
    private String description;

    @Schema(description = "Position status")
    @TableField(value = "status")
    private BaseStatus status;

}
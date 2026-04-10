package com.dong.lease.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    @Schema(description = "Primary key")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "Creation time")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonIgnore
    private Date createTime;

    @Schema(description = "Update time")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @JsonIgnore
    private Date updateTime;

    @Schema(description = "Logical deletion flag")
    @TableField("is_deleted")
    @JsonIgnore
    @TableLogic
    private Byte isDeleted;

}
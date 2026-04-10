package com.dong.lease.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Schema(description = "Room Attribute Value Table")
@TableName(value = "attr_value")
@Data
public class AttrValue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Attribute value")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Corresponding attribute key ID")
    @TableField(value = "attr_key_id")
    private Long attrKeyId;
}
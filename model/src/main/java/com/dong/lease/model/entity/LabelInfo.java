package com.dong.lease.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.dong.lease.model.enums.ItemType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Schema(description = "Label Information Table")
@TableName(value = "label_info")
@Data
public class LabelInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Label type (e.g., apartment, room)")
    @TableField(value = "type")
    private ItemType type;

    @Schema(description = "Label name")
    @TableField(value = "name")
    private String name;

}
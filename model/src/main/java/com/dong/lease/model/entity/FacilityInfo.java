package com.dong.lease.model.entity;

import com.dong.lease.model.enums.ItemType;
import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Schema(description = "Facility Information Table")
@TableName(value = "facility_info")
@Data
public class FacilityInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Schema(description = "Type of associated object")
    @TableField(value = "type")
    private ItemType type;

    @Schema(description = "Name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Icon")
    @TableField(value = "icon")
    private String icon;

}
package com.dong.lease.model.entity;

import com.dong.lease.model.enums.ReleaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Room information table")
@TableName(value = "room_info")
@Data
public class RoomInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Room number")
    @TableField(value = "room_number")
    private String roomNumber;

    @Schema(description = "Rent (CNY/month)")
    @TableField(value = "rent")
    private BigDecimal rent;

    @Schema(description = "Apartment ID")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    @Schema(description = "Release status")
    @TableField(value = "is_release")
    private ReleaseStatus isRelease;
}
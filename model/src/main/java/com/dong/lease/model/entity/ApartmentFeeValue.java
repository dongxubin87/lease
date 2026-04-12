package com.dong.lease.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Apartment & Fee Association Table")
@TableName(value = "apartment_fee_value")
@Data
@Builder
public class ApartmentFeeValue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Apartment ID")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    @Schema(description = "Fee value ID")
    @TableField(value = "fee_value_id")
    private Long feeValueId;

}
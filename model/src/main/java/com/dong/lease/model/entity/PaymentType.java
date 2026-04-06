package com.dong.lease.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Payment Method Table")
@TableName(value = "payment_type")
@Data
public class PaymentType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Payment method name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Number of months per payment")
    @TableField(value = "pay_month_count")
    private String payMonthCount;

    @Schema(description = "Payment description / notes")
    @TableField(value = "additional_info")
    private String additionalInfo;

}
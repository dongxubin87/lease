package com.dong.lease.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.dong.lease.model.enums.LeaseSourceType;
import com.dong.lease.model.enums.LeaseStatus;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Schema(description = "Lease Agreement Table")
@TableName(value = "lease_agreement")
@Data
public class LeaseAgreement extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Tenant phone number")
    @TableField(value = "phone")
    private String phone;

    @Schema(description = "Tenant name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Tenant ID card number")
    @TableField(value = "identification_number")
    private String identificationNumber;

    @Schema(description = "Leased apartment ID")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    @Schema(description = "Leased room ID")
    @TableField(value = "room_id")
    private Long roomId;

    @Schema(description = "Lease start date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "lease_start_date")
    private Date leaseStartDate;

    @Schema(description = "Lease end date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "lease_end_date")
    private Date leaseEndDate;

    @Schema(description = "Lease term ID")
    @TableField(value = "lease_term_id")
    private Long leaseTermId;

    @Schema(description = "Rent (per month)")
    @TableField(value = "rent")
    private BigDecimal rent;

    @Schema(description = "Deposit")
    @TableField(value = "deposit")
    private BigDecimal deposit;

    @Schema(description = "Payment type ID")
    @TableField(value = "payment_type_id")
    private Long paymentTypeId;

    @Schema(description = "Lease status")
    @TableField(value = "status")
    private LeaseStatus status;

    @Schema(description = "Lease source type")
    @TableField(value = "source_type")
    private LeaseSourceType sourceType;

    @Schema(description = "Additional notes")
    @TableField(value = "additional_info")
    private String additionalInfo;

}
package com.dong.lease.model.entity;

import com.dong.lease.model.enums.AppointmentStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Schema(description = "Viewing Appointment Information Table")
@TableName(value = "view_appointment")
@Data
public class ViewAppointment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "User ID")
    @TableField(value = "user_id")
    private Long userId;

    @Schema(description = "User name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "User phone number")
    @TableField(value = "phone")
    private String phone;

    @Schema(description = "Apartment ID")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    @Schema(description = "Appointment time")
    @TableField(value = "appointment_time")
    private Date appointmentTime;

    @Schema(description = "Additional information")
    @TableField(value = "additional_info")
    private String additionalInfo;

    @Schema(description = "Appointment status")
    @TableField(value = "appointment_status")
    private AppointmentStatus appointmentStatus;
}
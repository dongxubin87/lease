package com.dong.lease.web.admin.vo.appointment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "View Appointment Query Object")
public class AppointmentQueryVo {

    @Schema(description = "Province where the appointment apartment is located")
    private Long provinceId;

    @Schema(description = "City where the appointment apartment is located")
    private Long cityId;

    @Schema(description = "District where the appointment apartment is located")
    private Long districtId;

    @Schema(description = "Apartment for the appointment")
    private Long apartmentId;

    @Schema(description = "Name of the appointment user")
    private String name;

    @Schema(description = "Phone number of the appointment user")
    private String phone;

}
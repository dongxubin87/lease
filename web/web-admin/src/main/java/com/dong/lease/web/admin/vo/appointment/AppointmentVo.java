package com.dong.lease.web.admin.vo.appointment;

import com.dong.lease.model.entity.ApartmentInfo;
import com.dong.lease.model.entity.ViewAppointment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "View Appointment Information")
public class AppointmentVo extends ViewAppointment {

    @Schema(description = "Apartment information for the appointment")
    private ApartmentInfo apartmentInfo;

}
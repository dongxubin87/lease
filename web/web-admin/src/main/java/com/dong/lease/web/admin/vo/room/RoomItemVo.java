package com.dong.lease.web.admin.vo.room;

import com.dong.lease.model.entity.ApartmentInfo;
import com.dong.lease.model.entity.RoomInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "Room Information")
public class RoomItemVo extends RoomInfo {

    @Schema(description = "Lease end date")
    private Date leaseEndDate;

    @Schema(description = "Current check-in status")
    private Boolean isCheckIn;

    @Schema(description = "Associated apartment information")
    private ApartmentInfo apartmentInfo;

}
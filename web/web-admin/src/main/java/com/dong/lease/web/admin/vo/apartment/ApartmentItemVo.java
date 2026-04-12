package com.dong.lease.web.admin.vo.apartment;

import com.dong.lease.model.entity.ApartmentInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Admin system apartment list entity")
public class ApartmentItemVo extends ApartmentInfo {

    @Schema(description = "Total number of rooms")
    private Long totalRoomCount;

    @Schema(description = "Number of available rooms")
    private Long freeRoomCount;

}
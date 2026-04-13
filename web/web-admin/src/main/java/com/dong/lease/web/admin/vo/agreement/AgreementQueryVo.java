package com.dong.lease.web.admin.vo.agreement;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Lease Agreement Query Object")
public class AgreementQueryVo {

    @Schema(description = "Province ID where the apartment is located")
    private Long provinceId;

    @Schema(description = "City ID where the apartment is located")
    private Long cityId;

    @Schema(description = "District ID where the apartment is located")
    private Long districtId;

    @Schema(description = "Apartment ID")
    private Long apartmentId;

    @Schema(description = "Room number")
    private String roomNumber;

    @Schema(description = "User name")
    private String name;

    @Schema(description = "User phone number")
    private String phone;

}
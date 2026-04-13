package com.dong.lease.web.admin.vo.agreement;

import com.dong.lease.model.entity.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Lease Agreement Information")
public class AgreementVo extends LeaseAgreement {

    @Schema(description = "Associated apartment information")
    private ApartmentInfo apartmentInfo;

    @Schema(description = "Associated room information")
    private RoomInfo roomInfo;

    @Schema(description = "Payment type")
    private PaymentType paymentType;

    @Schema(description = "Lease term")
    private LeaseTerm leaseTerm;
}
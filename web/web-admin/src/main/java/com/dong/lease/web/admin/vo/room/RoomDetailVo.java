package com.dong.lease.web.admin.vo.room;

import com.dong.lease.model.entity.*;
import com.dong.lease.web.admin.vo.attr.AttrValueVo;
import com.dong.lease.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Room Information")
@Data
public class RoomDetailVo extends RoomInfo {

    @Schema(description = "Associated apartment information")
    private ApartmentInfo apartmentInfo;

    @Schema(description = "Image list")
    private List<GraphVo> graphVoList;

    @Schema(description = "Attribute value list")
    private List<AttrValueVo> attrValueVoList;

    @Schema(description = "Facility information list")
    private List<FacilityInfo> facilityInfoList;

    @Schema(description = "Label information list")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "Payment type list")
    private List<PaymentType> paymentTypeList;

    @Schema(description = "Available lease term list")
    private List<LeaseTerm> leaseTermList;
}
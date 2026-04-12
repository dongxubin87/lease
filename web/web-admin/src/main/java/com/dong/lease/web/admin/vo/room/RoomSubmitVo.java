package com.dong.lease.web.admin.vo.room;

import com.dong.lease.model.entity.RoomInfo;
import com.dong.lease.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Room Information")
public class RoomSubmitVo extends RoomInfo {

    @Schema(description = "Image list")
    private List<GraphVo> graphVoList;

    @Schema(description = "Attribute value ID list")
    private List<Long> attrValueIds;

    @Schema(description = "Facility ID list")
    private List<Long> facilityInfoIds;

    @Schema(description = "Label ID list")
    private List<Long> labelInfoIds;

    @Schema(description = "Payment type ID list")
    private List<Long> paymentTypeIds;

    @Schema(description = "Available lease term ID list")
    private List<Long> leaseTermIds;

}
package com.dong.lease.web.admin.vo.apartment;

import com.dong.lease.model.entity.ApartmentInfo;
import com.dong.lease.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Apartment Information")
@Data
public class ApartmentSubmitVo extends ApartmentInfo {

    @Schema(description = "Facility IDs for the apartment")
    private List<Long> facilityInfoIds;

    @Schema(description = "Label IDs for the apartment")
    private List<Long> labelIds;

    @Schema(description = "Fee value IDs for the apartment")
    private List<Long> feeValueIds;

    @Schema(description = "Apartment image list")
    private List<GraphVo> graphVoList;

}
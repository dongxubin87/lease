package com.dong.lease.web.admin.vo.apartment;

import com.dong.lease.model.entity.ApartmentInfo;
import com.dong.lease.model.entity.FacilityInfo;
import com.dong.lease.model.entity.LabelInfo;
import com.dong.lease.web.admin.vo.graph.GraphVo;
import com.dong.lease.web.admin.vo.fee.FeeValueVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Apartment Detail Information")
@Data
public class ApartmentDetailVo extends ApartmentInfo {

    @Schema(description = "Image list")
    private List<GraphVo> graphVoList;

    @Schema(description = "Label list")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "Facility list")
    private List<FacilityInfo> facilityInfoList;

    @Schema(description = "Fee list")
    private List<FeeValueVo> feeValueVoList;

}
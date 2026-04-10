package com.dong.lease.web.admin.vo.fee;

import com.dong.lease.model.entity.FeeKey;
import com.dong.lease.model.entity.FeeValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class FeeKeyVo extends FeeKey {

    @Schema(description = "List of fee values")
    private List<FeeValue> feeValueList;
}
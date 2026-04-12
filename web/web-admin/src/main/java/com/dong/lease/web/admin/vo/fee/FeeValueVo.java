package com.dong.lease.web.admin.vo.fee;

import com.dong.lease.model.entity.FeeValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Fee Value")
@Data
public class FeeValueVo extends FeeValue {

    @Schema(description = "Fee key name")
    private String feeKeyName;
}
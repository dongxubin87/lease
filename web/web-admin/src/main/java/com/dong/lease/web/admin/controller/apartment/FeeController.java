package com.dong.lease.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dong.lease.common.result.Result;
import com.dong.lease.model.entity.FeeKey;
import com.dong.lease.model.entity.FeeValue;
import com.dong.lease.web.admin.service.FeeKeyService;
import com.dong.lease.web.admin.service.FeeValueService;
import com.dong.lease.web.admin.vo.fee.FeeKeyVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Room Fee Management")
@RestController
@RequestMapping("/admin/fee")
public class FeeController {

    @Autowired
    private FeeKeyService feeKeyService;

    @Autowired
    private FeeValueService feeValueService;

    @Operation(summary = "Add or update fee key")
    @PostMapping("key/saveOrUpdate")
    public Result saveOrUpdateFeeKey(@RequestBody FeeKey feeKey) {
        feeKeyService.saveOrUpdate(feeKey);
        return Result.ok();
    }

    @Operation(summary = "Add or update fee value")
    @PostMapping("value/saveOrUpdate")
    public Result saveOrUpdateFeeValue(@RequestBody FeeValue feeValue) {
        feeValueService.saveOrUpdate(feeValue);
        return Result.ok();
    }

    @Operation(summary = "Get list of all fee keys and values")
    @GetMapping("list")
    public Result<List<FeeKeyVo>> listFeeInfo() {
        List<FeeKeyVo> list = feeKeyService.listFeeInfo();
        return Result.ok(list);
    }

    @Operation(summary = "Delete fee key by ID")
    @DeleteMapping("key/deleteById")
    public Result deleteFeeKeyById(@RequestParam Long feeKeyId) {
        feeKeyService.removeById(feeKeyId);
        LambdaQueryWrapper<FeeValue> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(FeeValue::getFeeKeyId, feeKeyId);
        feeValueService.remove(queryWrapper);
        return Result.ok();
    }

    @Operation(summary = "Delete fee value by ID")
    @DeleteMapping("value/deleteById")
    public Result deleteFeeValueById(@RequestParam Long id) {
        feeValueService.removeById(id);
        return Result.ok();
    }
}
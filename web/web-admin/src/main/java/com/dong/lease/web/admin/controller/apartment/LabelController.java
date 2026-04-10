package com.dong.lease.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dong.lease.common.result.Result;
import com.dong.lease.model.entity.LabelInfo;
import com.dong.lease.model.enums.ItemType;
import com.dong.lease.web.admin.service.LabelInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Label Management")
@RestController
@RequestMapping("/admin/label")
public class LabelController {

    @Autowired
    private LabelInfoService service;

    @Operation(summary = "Get label list by type (optional)")
    @GetMapping("list")
    public Result<List<LabelInfo>> labelList(@RequestParam(required = false) ItemType type) {
        LambdaQueryWrapper<LabelInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(type != null,LabelInfo::getType, type);
        List<LabelInfo> list = service.list(queryWrapper);
        return Result.ok(list);
    }

    @Operation(summary = "Create or update a label")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdateLabel(@RequestBody LabelInfo labelInfo) {
        service.saveOrUpdate(labelInfo);
        return Result.ok();
    }

    @Operation(summary = "Delete a label by ID")
    @DeleteMapping("deleteById")
    public Result deleteLabelById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }
}
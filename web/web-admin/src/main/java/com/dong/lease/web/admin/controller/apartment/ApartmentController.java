package com.dong.lease.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dong.lease.common.result.Result;
import com.dong.lease.model.entity.ApartmentInfo;
import com.dong.lease.model.enums.ReleaseStatus;
import com.dong.lease.web.admin.service.ApartmentInfoService;
import com.dong.lease.web.admin.vo.apartment.ApartmentDetailVo;
import com.dong.lease.web.admin.vo.apartment.ApartmentItemVo;
import com.dong.lease.web.admin.vo.apartment.ApartmentQueryVo;
import com.dong.lease.web.admin.vo.apartment.ApartmentSubmitVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Apartment Management")
@RestController
@RequestMapping("/admin/apartment")
public class ApartmentController {

    @Autowired
    private ApartmentInfoService service;

    @Operation(summary = "Save or update apartment information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody ApartmentSubmitVo apartmentSubmitVo) {
        service.saveOrUpdateApartment(apartmentSubmitVo);
        return Result.ok();
    }

    @Operation(summary = "Query apartment list by conditions with pagination")
    @GetMapping("pageItem")
    public Result<IPage<ApartmentItemVo>> pageItem(@RequestParam long current, @RequestParam long size, ApartmentQueryVo queryVo) {
        Page<ApartmentItemVo> page = new Page<>(current, size);
        IPage<ApartmentItemVo> list = service.pageItem(page, queryVo);
        return Result.ok(list);
    }

    @Operation(summary = "Get apartment details by ID")
    @GetMapping("getDetailById")
    public Result<ApartmentDetailVo> getDetailById(@RequestParam Long id) {
        ApartmentDetailVo apartmentInfo = service.getApartmentDetailById(id);
        return Result.ok(apartmentInfo);
    }

    @Operation(summary = "Delete apartment information by ID")
    @DeleteMapping("removeById")
    public Result removeById(@RequestParam Long id) {
        service.removeApartmentById(id);
        return Result.ok();
    }

    @Operation(summary = "Update apartment release status by ID")
    @PostMapping("updateReleaseStatusById")
    public Result updateReleaseStatusById(@RequestParam Long id, @RequestParam ReleaseStatus status) {

        LambdaUpdateWrapper<ApartmentInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ApartmentInfo::getId, id);
        updateWrapper.set(ApartmentInfo::getIsRelease, status);
        service.update(updateWrapper);
        return Result.ok();
    }

    @Operation(summary = "List apartments by district ID")
    @GetMapping("listInfoByDistrictId")
    public Result<List<ApartmentInfo>> listInfoByDistrictId(@RequestParam Long id) {
        LambdaQueryWrapper<ApartmentInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ApartmentInfo::getDistrictId, id);
        List<ApartmentInfo> list = service.list(queryWrapper);
        return Result.ok(list);
    }
}
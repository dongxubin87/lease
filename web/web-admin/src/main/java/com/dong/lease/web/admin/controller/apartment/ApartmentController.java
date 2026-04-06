package com.dong.lease.web.admin.controller.apartment;

import com.dong.lease.common.result.Result;
import com.dong.lease.model.entity.ApartmentInfo;
import com.dong.lease.model.enums.ReleaseStatus;
import com.dong.lease.web.admin.vo.apartment.ApartmentDetailVo;
import com.dong.lease.web.admin.vo.apartment.ApartmentItemVo;
import com.dong.lease.web.admin.vo.apartment.ApartmentQueryVo;
import com.dong.lease.web.admin.vo.apartment.ApartmentSubmitVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Apartment Management")
@RestController
@RequestMapping("/admin/apartment")
public class ApartmentController {

    @Operation(summary = "Save or update apartment information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody ApartmentSubmitVo apartmentSubmitVo) {
        return Result.ok();
    }

    @Operation(summary = "Query apartment list by conditions with pagination")
    @GetMapping("pageItem")
    public Result<IPage<ApartmentItemVo>> pageItem(@RequestParam long current, @RequestParam long size, ApartmentQueryVo queryVo) {
        return Result.ok();
    }

    @Operation(summary = "Get apartment details by ID")
    @GetMapping("getDetailById")
    public Result<ApartmentDetailVo> getDetailById(@RequestParam Long id) {
        return Result.ok();
    }

    @Operation(summary = "Delete apartment information by ID")
    @DeleteMapping("removeById")
    public Result removeById(@RequestParam Long id) {
        return Result.ok();
    }

    @Operation(summary = "Update apartment release status by ID")
    @PostMapping("updateReleaseStatusById")
    public Result updateReleaseStatusById(@RequestParam Long id, @RequestParam ReleaseStatus status) {
        return Result.ok();
    }

    @Operation(summary = "List apartments by district ID")
    @GetMapping("listInfoByDistrictId")
    public Result<List<ApartmentInfo>> listInfoByDistrictId(@RequestParam Long id) {
        return Result.ok();
    }
}
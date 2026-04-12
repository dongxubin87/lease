package com.dong.lease.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dong.lease.common.result.Result;
import com.dong.lease.model.entity.CityInfo;
import com.dong.lease.model.entity.DistrictInfo;
import com.dong.lease.model.entity.ProvinceInfo;
import com.dong.lease.web.admin.service.CityInfoService;
import com.dong.lease.web.admin.service.DistrictInfoService;
import com.dong.lease.web.admin.service.ProvinceInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Region Management")
@RestController
@RequestMapping("/admin/region")
public class RegionInfoController {

    @Autowired
    private ProvinceInfoService provinceInfoService;

    @Autowired
    private CityInfoService cityInfoService;

    @Autowired
    private DistrictInfoService districtInfoService;

    @Operation(summary = "Get list of provinces")
    @GetMapping("province/list")
    public Result<List<ProvinceInfo>> listProvinces() {
        List<ProvinceInfo> list = provinceInfoService.list();
        return Result.ok(list);
    }

    @Operation(summary = "Get list of cities by province ID")
    @GetMapping("city/listByProvinceId")
    public Result<List<CityInfo>> listCitiesByProvinceId(@RequestParam Long id) {
        LambdaQueryWrapper<CityInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CityInfo::getProvinceId, id);
        List<CityInfo> list = cityInfoService.list(queryWrapper);
        return Result.ok(list);
    }

    @Operation(summary = "Get list of districts by city ID")
    @GetMapping("district/listByCityId")
    public Result<List<DistrictInfo>> listDistrictsByCityId(@RequestParam Long id) {
        LambdaQueryWrapper<DistrictInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DistrictInfo::getCityId, id);
        List<DistrictInfo> list = districtInfoService.list(queryWrapper);
        return Result.ok(list);
    }

}
package com.dong.lease.web.admin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dong.lease.common.result.Result;
import com.dong.lease.model.entity.RoomInfo;
import com.dong.lease.model.enums.ReleaseStatus;
import com.dong.lease.web.admin.service.RoomInfoService;
import com.dong.lease.web.admin.vo.room.RoomDetailVo;
import com.dong.lease.web.admin.vo.room.RoomItemVo;
import com.dong.lease.web.admin.vo.room.RoomQueryVo;
import com.dong.lease.web.admin.vo.room.RoomSubmitVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Room Information Management")
@RestController
@RequestMapping("/admin/room")
public class RoomController {

    @Autowired
    private RoomInfoService service;

    @Operation(summary = "Create or update room information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody RoomSubmitVo roomSubmitVo) {
        service.saveOrUpdateRoom(roomSubmitVo);
        return Result.ok();
    }

    @Operation(summary = "Query paginated room list by conditions")
    @GetMapping("pageItem")
    public Result<IPage<RoomItemVo>> pageItem(@RequestParam long current, @RequestParam long size, RoomQueryVo queryVo) {
        IPage<RoomItemVo> page = new Page<>(current, size);
        IPage<RoomItemVo> result = service.pageRoomItemByQuery(page, queryVo);
        return Result.ok(result);
    }

    @Operation(summary = "Get room detail by ID")
    @GetMapping("getDetailById")
    public Result<RoomDetailVo> getDetailById(@RequestParam Long id) {
        RoomDetailVo roomInfo = service.getRoomDetailById(id);
        return Result.ok(roomInfo);
    }

    @Operation(summary = "Delete room information by ID")
    @DeleteMapping("removeById")
    public Result removeById(@RequestParam Long id) {
        service.removeRoomById(id);
        return Result.ok();
    }

    @Operation(summary = "Update room release status by ID")
    @PostMapping("updateReleaseStatusById")
    public Result updateReleaseStatusById(@RequestParam Long id, @RequestParam ReleaseStatus status) {
        LambdaUpdateWrapper<RoomInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(RoomInfo::getId, id);
        updateWrapper.set(RoomInfo::getIsRelease, status);
        service.update(updateWrapper);
        return Result.ok();
    }

    @GetMapping("listBasicByApartmentId")
    @Operation(summary = "Query room list by apartment ID")
    public Result<List<RoomInfo>> listBasicByApartmentId(@RequestParam Long id) {
        LambdaQueryWrapper<RoomInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoomInfo::getApartmentId, id);
        queryWrapper.eq(RoomInfo::getIsRelease, ReleaseStatus.RELEASED);
        List<RoomInfo> roomInfoList = service.list(queryWrapper);
        return Result.ok(roomInfoList);
    }
}
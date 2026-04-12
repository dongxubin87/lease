package com.dong.lease.web.admin.controller.lease;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dong.lease.common.result.Result;
import com.dong.lease.model.entity.ViewAppointment;
import com.dong.lease.model.enums.AppointmentStatus;
import com.dong.lease.web.admin.service.ViewAppointmentService;
import com.dong.lease.web.admin.vo.appointment.AppointmentQueryVo;
import com.dong.lease.web.admin.vo.appointment.AppointmentVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "View Appointment Management")
@RequestMapping("/admin/appointment")
@RestController
public class ViewAppointmentController {

    @Autowired
    private ViewAppointmentService service;

    @Operation(summary = "Paginated query of appointment information")
    @GetMapping("page")
    public Result<IPage<AppointmentVo>> page(@RequestParam long current, @RequestParam long size, AppointmentQueryVo queryVo) {
        IPage<AppointmentVo> page = new Page<>(current, size);
        IPage<AppointmentVo> list = service.pageAppointmentByQuery(page, queryVo);
        return Result.ok(list);
    }

    @Operation(summary = "Update appointment status by ID")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam AppointmentStatus status) {
        LambdaUpdateWrapper<ViewAppointment> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ViewAppointment::getId, id);
        updateWrapper.set(ViewAppointment::getAppointmentStatus, status);
        service.update(updateWrapper);
        return Result.ok();
    }

}
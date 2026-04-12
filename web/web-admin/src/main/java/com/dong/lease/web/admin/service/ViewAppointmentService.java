package com.dong.lease.web.admin.service;

import com.dong.lease.model.entity.ViewAppointment;
import com.dong.lease.web.admin.vo.appointment.AppointmentQueryVo;
import com.dong.lease.web.admin.vo.appointment.AppointmentVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;


public interface ViewAppointmentService extends IService<ViewAppointment> {

    IPage<AppointmentVo> pageAppointmentByQuery(IPage<AppointmentVo> page, AppointmentQueryVo queryVo);
}

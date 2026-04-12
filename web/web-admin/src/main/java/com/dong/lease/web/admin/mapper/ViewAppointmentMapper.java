package com.dong.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dong.lease.model.entity.ViewAppointment;
import com.dong.lease.web.admin.vo.appointment.AppointmentQueryVo;
import com.dong.lease.web.admin.vo.appointment.AppointmentVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface ViewAppointmentMapper extends BaseMapper<ViewAppointment> {

    IPage<AppointmentVo> pageAppointmentByQuery(IPage<AppointmentVo> page, AppointmentQueryVo queryVo);
}





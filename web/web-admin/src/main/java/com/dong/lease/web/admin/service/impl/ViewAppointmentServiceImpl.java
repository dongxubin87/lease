package com.dong.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dong.lease.model.entity.ViewAppointment;
import com.dong.lease.web.admin.mapper.ViewAppointmentMapper;
import com.dong.lease.web.admin.service.ViewAppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dong.lease.web.admin.vo.appointment.AppointmentQueryVo;
import com.dong.lease.web.admin.vo.appointment.AppointmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment>
        implements ViewAppointmentService {

    @Autowired
    private ViewAppointmentMapper viewAppointmentMapper;
    @Override
    public IPage<AppointmentVo> pageAppointmentByQuery(IPage<AppointmentVo> page, AppointmentQueryVo queryVo) {
        return viewAppointmentMapper.pageAppointmentByQuery(page, queryVo);
    }
}





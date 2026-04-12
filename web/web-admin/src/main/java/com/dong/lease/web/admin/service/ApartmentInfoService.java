package com.dong.lease.web.admin.service;

import com.dong.lease.model.entity.ApartmentInfo;
import com.dong.lease.web.admin.vo.apartment.ApartmentDetailVo;
import com.dong.lease.web.admin.vo.apartment.ApartmentItemVo;
import com.dong.lease.web.admin.vo.apartment.ApartmentQueryVo;
import com.dong.lease.web.admin.vo.apartment.ApartmentSubmitVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;


public interface ApartmentInfoService extends IService<ApartmentInfo> {

    void saveOrUpdateApartment(ApartmentSubmitVo apartmentSubmitVo);

    IPage<ApartmentItemVo> pageItem(Page<ApartmentItemVo> page, ApartmentQueryVo queryVo);

    ApartmentDetailVo getApartmentDetailById(Long id);

    void removeApartmentById(Long id);
}

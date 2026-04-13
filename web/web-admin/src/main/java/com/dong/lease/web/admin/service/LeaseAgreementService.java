package com.dong.lease.web.admin.service;

import com.dong.lease.model.entity.LeaseAgreement;
import com.dong.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.dong.lease.web.admin.vo.agreement.AgreementVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;


public interface LeaseAgreementService extends IService<LeaseAgreement> {

    IPage<AgreementVo> pageAgreementByQuery(IPage<AgreementVo> page, AgreementQueryVo queryVo);

    AgreementVo getAgreementById(Long id);
}

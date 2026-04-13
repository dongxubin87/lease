package com.dong.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dong.lease.model.entity.LeaseAgreement;
import com.dong.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.dong.lease.web.admin.vo.agreement.AgreementVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    IPage<AgreementVo> pageAgreementByQuery(IPage<AgreementVo> page, AgreementQueryVo queryVo);
}





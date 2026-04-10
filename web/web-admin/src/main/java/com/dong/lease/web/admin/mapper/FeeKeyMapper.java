package com.dong.lease.web.admin.mapper;

import com.dong.lease.model.entity.FeeKey;
import com.dong.lease.web.admin.vo.fee.FeeKeyVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface FeeKeyMapper extends BaseMapper<FeeKey> {

    List<FeeKeyVo> listFeeInfo();
}





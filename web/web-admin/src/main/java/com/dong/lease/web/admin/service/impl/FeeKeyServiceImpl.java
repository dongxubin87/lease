package com.dong.lease.web.admin.service.impl;

import com.dong.lease.model.entity.FeeKey;
import com.dong.lease.web.admin.mapper.FeeKeyMapper;
import com.dong.lease.web.admin.service.FeeKeyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dong.lease.web.admin.vo.fee.FeeKeyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey>
    implements FeeKeyService{

    @Autowired
    private FeeKeyMapper mapper;

    @Override
    public List<FeeKeyVo> listFeeInfo() {

        return mapper.listFeeInfo();
    }
}





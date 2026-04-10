package com.dong.lease.web.admin.service.impl;

import com.dong.lease.model.entity.AttrKey;
import com.dong.lease.web.admin.mapper.AttrKeyMapper;
import com.dong.lease.web.admin.service.AttrKeyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dong.lease.web.admin.vo.attr.AttrKeyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttrKeyServiceImpl extends ServiceImpl<AttrKeyMapper, AttrKey>
    implements AttrKeyService{

    @Autowired
    private AttrKeyMapper mapper;

    @Override
    public List<AttrKeyVo> listAttrInfo() {
        return mapper.listAttrInfo();
    }
}





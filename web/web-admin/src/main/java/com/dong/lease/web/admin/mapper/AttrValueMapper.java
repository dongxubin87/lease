package com.dong.lease.web.admin.mapper;

import com.dong.lease.model.entity.AttrValue;
import com.dong.lease.web.admin.vo.attr.AttrValueVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface AttrValueMapper extends BaseMapper<AttrValue> {

    List<AttrValueVo> selectListByRoomId(Long id);
}





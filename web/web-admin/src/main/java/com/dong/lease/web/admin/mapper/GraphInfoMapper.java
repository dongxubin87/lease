package com.dong.lease.web.admin.mapper;

import com.dong.lease.model.entity.GraphInfo;
import com.dong.lease.model.enums.ItemType;
import com.dong.lease.web.admin.vo.graph.GraphVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface GraphInfoMapper extends BaseMapper<GraphInfo> {

    List<GraphVo> selectListByItemTypeAndId(ItemType itemType, Long itemId);
}





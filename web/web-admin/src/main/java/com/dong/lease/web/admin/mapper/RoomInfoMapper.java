package com.dong.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dong.lease.model.entity.RoomInfo;
import com.dong.lease.web.admin.vo.room.RoomItemVo;
import com.dong.lease.web.admin.vo.room.RoomQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> page, RoomQueryVo queryVo);
}





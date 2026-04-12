package com.dong.lease.web.admin.service;

import com.dong.lease.model.entity.RoomInfo;
import com.dong.lease.web.admin.vo.room.RoomDetailVo;
import com.dong.lease.web.admin.vo.room.RoomItemVo;
import com.dong.lease.web.admin.vo.room.RoomQueryVo;
import com.dong.lease.web.admin.vo.room.RoomSubmitVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;


public interface RoomInfoService extends IService<RoomInfo> {

    void saveOrUpdateRoom(RoomSubmitVo roomSubmitVo);

    IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> page, RoomQueryVo queryVo);

    RoomDetailVo getRoomDetailById(Long id);

    void removeRoomById(Long id);
}

package com.dong.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dong.lease.common.exception.LeaseException;
import com.dong.lease.common.result.ResultCodeEnum;
import com.dong.lease.model.entity.*;
import com.dong.lease.model.enums.ItemType;
import com.dong.lease.web.admin.mapper.*;
import com.dong.lease.web.admin.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dong.lease.web.admin.vo.apartment.ApartmentDetailVo;
import com.dong.lease.web.admin.vo.apartment.ApartmentItemVo;
import com.dong.lease.web.admin.vo.apartment.ApartmentQueryVo;
import com.dong.lease.web.admin.vo.apartment.ApartmentSubmitVo;
import com.dong.lease.web.admin.vo.fee.FeeValueVo;
import com.dong.lease.web.admin.vo.graph.GraphVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
        implements ApartmentInfoService {

    @Autowired
    private ApartmentInfoMapper apartmentInfoMapper;

    @Autowired
    private GraphInfoMapper graphInfoMapper;

    @Autowired
    private LabelInfoMapper labelInfoMapper;

    @Autowired
    private FacilityInfoMapper facilityInfoMapper;

    @Autowired
    private FeeValueMapper feeValueMapper;

    @Autowired
    private RoomInfoMapper roomInfoMapper;

    @Autowired
    private GraphInfoService graphInfoService;

    @Autowired
    private ApartmentFacilityService apartmentFacilityService;

    @Autowired
    private ApartmentLabelService apartmentLabelService;

    @Autowired
    private ApartmentFeeValueService apartmentFeeValueService;

    @Override
    public void saveOrUpdateApartment(ApartmentSubmitVo apartmentSubmitVo) {
        boolean isUpdate = apartmentSubmitVo.getId()!=null;
        super.saveOrUpdate(apartmentSubmitVo);

        if (isUpdate){
            //1. Delete image list
            LambdaQueryWrapper<GraphInfo> graphQueryWrapper = new LambdaQueryWrapper<>();
            graphQueryWrapper.eq(GraphInfo::getItemType, ItemType.APARTMENT);
            graphQueryWrapper.eq(GraphInfo::getItemId,apartmentSubmitVo.getId());
            graphInfoService.remove(graphQueryWrapper);

            //2. Delete facility list
            LambdaQueryWrapper<ApartmentFacility> facilityQueryWrapper = new LambdaQueryWrapper<>();
            facilityQueryWrapper.eq(ApartmentFacility::getApartmentId,apartmentSubmitVo.getId());
            apartmentFacilityService.remove(facilityQueryWrapper);

            //3. Delete label list
            LambdaQueryWrapper<ApartmentLabel> labelQueryWrapper = new LambdaQueryWrapper<>();
            labelQueryWrapper.eq(ApartmentLabel::getApartmentId,apartmentSubmitVo.getId());
            apartmentLabelService.remove(labelQueryWrapper);

            //4. Delete fee list
            LambdaQueryWrapper<ApartmentFeeValue> feeQueryWrapper = new LambdaQueryWrapper<>();
            feeQueryWrapper.eq(ApartmentFeeValue::getApartmentId,apartmentSubmitVo.getId());
            apartmentFeeValueService.remove(feeQueryWrapper);

        }

        //1. Insert image list
        List<GraphVo> graphVoList = apartmentSubmitVo.getGraphVoList();
        if (!CollectionUtils.isEmpty(graphVoList)){
            ArrayList<GraphInfo> graphInfoList = new ArrayList<>();
            for (GraphVo graphVo : graphVoList) {
                GraphInfo graphInfo = new GraphInfo();
                graphInfo.setItemType(ItemType.APARTMENT);
                graphInfo.setItemId(apartmentSubmitVo.getId());
                graphInfo.setName(graphVo.getName());
                graphInfo.setUrl(graphVo.getUrl());
                graphInfoList.add(graphInfo);
            }
            graphInfoService.saveBatch(graphInfoList);
        }

        //2. Insert facility list
        List<Long> facilityInfoIdList = apartmentSubmitVo.getFacilityInfoIds();
        if (!CollectionUtils.isEmpty(facilityInfoIdList)){
            ArrayList<ApartmentFacility> facilityList = new ArrayList<>();
            for (Long facilityId : facilityInfoIdList) {

                ApartmentFacility apartmentFacility = ApartmentFacility.builder()
                        .apartmentId(apartmentSubmitVo.getId())
                        .facilityId(facilityId)
                        .build();

                facilityList.add(apartmentFacility);
            }
            apartmentFacilityService.saveBatch(facilityList);
        }

        //3. Insert label list
        List<Long> labelIds = apartmentSubmitVo.getLabelIds();
        if (!CollectionUtils.isEmpty(labelIds)) {
            List<ApartmentLabel> apartmentLabelList = new ArrayList<>();
            for (Long labelId : labelIds) {
                ApartmentLabel apartmentLabel = ApartmentLabel.builder()
                        .apartmentId(apartmentSubmitVo.getId())
                        .labelId(labelId)
                        .build();

                apartmentLabelList.add(apartmentLabel);
            }
            apartmentLabelService.saveBatch(apartmentLabelList);
        }

        //4. Insert fee list
        List<Long> feeValueIds = apartmentSubmitVo.getFeeValueIds();
        if (!CollectionUtils.isEmpty(feeValueIds)) {
            ArrayList<ApartmentFeeValue> apartmentFeeValueList = new ArrayList<>();
            for (Long feeValueId : feeValueIds) {
                ApartmentFeeValue apartmentFeeValue = ApartmentFeeValue.builder()
                        .apartmentId(apartmentSubmitVo.getId())
                        .feeValueId(feeValueId)
                        .build();

                apartmentFeeValueList.add(apartmentFeeValue);
            }
            apartmentFeeValueService.saveBatch(apartmentFeeValueList);
        }
    }

    @Override
    public IPage<ApartmentItemVo> pageItem(Page<ApartmentItemVo> page, ApartmentQueryVo queryVo) {
        return apartmentInfoMapper.pageItem(page,queryVo);
    }

    @Override
    public ApartmentDetailVo getApartmentDetailById(Long id) {
        //1.ApartmentInfo
        ApartmentInfo apartmentInfo = this.getById(id);
        if (apartmentInfo == null) {
            return null;
        }

        //2.GraphInfo
        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.APARTMENT, id);

        //3.LabelInfo
        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByApartmentId(id);

        //4.FacilityInfo
        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByApartmentId(id);

        //5.FeeValue
        List<FeeValueVo> feeValueVoList = feeValueMapper.selectListByApartmentId(id);

        ApartmentDetailVo apartmentDetailVo = new ApartmentDetailVo();

        BeanUtils.copyProperties(apartmentInfo, apartmentDetailVo);
        apartmentDetailVo.setGraphVoList(graphVoList);
        apartmentDetailVo.setLabelInfoList(labelInfoList);
        apartmentDetailVo.setFacilityInfoList(facilityInfoList);
        apartmentDetailVo.setFeeValueVoList(feeValueVoList);

        return apartmentDetailVo;
    }

    @Override
    public void removeApartmentById(Long id) {

        LambdaQueryWrapper<RoomInfo> roomQueryWrapper = new LambdaQueryWrapper<>();
        roomQueryWrapper.eq(RoomInfo::getApartmentId, id);
        Long count = roomInfoMapper.selectCount(roomQueryWrapper);
        if (count > 0) {
            throw new LeaseException(ResultCodeEnum. ADMIN_APARTMENT_DELETE_ERROR);
        }
        super.removeById(id);

        //1.GraphInfo
        LambdaQueryWrapper<GraphInfo> graphQueryWrapper = new LambdaQueryWrapper<>();
        graphQueryWrapper.eq(GraphInfo::getItemType, ItemType.APARTMENT);
        graphQueryWrapper.eq(GraphInfo::getItemId, id);
        graphInfoService.remove(graphQueryWrapper);

        //2.ApartmentLabel
        LambdaQueryWrapper<ApartmentLabel> labelQueryWrapper = new LambdaQueryWrapper<>();
        labelQueryWrapper.eq(ApartmentLabel::getApartmentId, id);
        apartmentLabelService.remove(labelQueryWrapper);

        //3.ApartmentFacility
        LambdaQueryWrapper<ApartmentFacility> facilityQueryWrapper = new LambdaQueryWrapper<>();
        facilityQueryWrapper.eq(ApartmentFacility::getApartmentId, id);
        apartmentFacilityService.remove(facilityQueryWrapper);

        //4.ApartmentFeeValue
        LambdaQueryWrapper<ApartmentFeeValue> feeQueryWrapper = new LambdaQueryWrapper<>();
        feeQueryWrapper.eq(ApartmentFeeValue::getApartmentId, id);
        apartmentFeeValueService.remove(feeQueryWrapper);

    }

}
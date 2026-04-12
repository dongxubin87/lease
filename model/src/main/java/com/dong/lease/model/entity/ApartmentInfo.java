package com.dong.lease.model.entity;

import com.dong.lease.model.enums.ReleaseStatus;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Apartment Information Table")
@TableName(value = "apartment_info")
@Data
public class ApartmentInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Apartment name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Apartment description")
    @TableField(value = "introduction")
    private String introduction;

    @Schema(description = "District ID")
    @TableField(value = "district_id")
    private Long districtId;

    @Schema(description = "District name")
    @TableField(value = "district_name")
    private String districtName;

    @Schema(description = "City ID")
    @TableField(value = "city_id")
    private Long cityId;

    @Schema(description = "City name")
    @TableField(value = "city_name")
    private String cityName;

    @Schema(description = "Province ID")
    @TableField(value = "province_id")
    private Long provinceId;

    @Schema(description = "Province name")
    @TableField(value = "province_name")
    private String provinceName;

    @Schema(description = "Detailed address")
    @TableField(value = "address_detail")
    private String addressDetail;

    @Schema(description = "Latitude")
    @TableField(value = "latitude")
    private String latitude;

    @Schema(description = "Longitude")
    @TableField(value = "longitude")
    private String longitude;

    @Schema(description = "Front desk phone number")
    @TableField(value = "phone")
    private String phone;

    @Schema(description = "Release status")
    @TableField(value = "is_release")
    private ReleaseStatus isRelease;
}
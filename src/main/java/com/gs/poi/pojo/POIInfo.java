package com.gs.poi.pojo;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class POIInfo {
    private long poiId;
    private boolean isInsertPoi;
    private int relativePosition;
    private long businessId;
    private String zoneName;
    private String poiName;
    private long commentCount;
    private double commentScore;
    private boolean isAdvertisement;
    private boolean isRecommend;
    private int districtId;
    private String districtName;
    private String coverImageUrl;
    private String distanceStr;
    private List<String> tagNameList;
    private List<OtherTagList> otherTagList;
    private int poiType;
    private String detailUrl;
    private DetailUrlInfo detailUrlInfo;
    private String displayField;
    private int marketPrice;
    private int preferentialPrice;
    private int price;
    private String priceType;
    private String priceTypeDesc;
    private boolean isFree;
    private String openStatus;
    private boolean isFromFavor;
    private List<String> shortFeatures;
    private String sightCategoryInfo;
    private boolean hasVideo;
    private List<String> childrenSightList;
    private boolean isCircuml;
    private Coordinate coordinate;
    private String heatScore;
    private int pkgposition;
    private int pagenumber;

    public boolean isSuccess(){
        return  this.poiId>0 &&
                !this.poiName.isEmpty()&&
                this.businessId>0&&
                null!=this.coverImageUrl&&
                null!=this.distanceStr&&
                null!=this.detailUrl&&
                null!=this.detailUrlInfo;
    }
}
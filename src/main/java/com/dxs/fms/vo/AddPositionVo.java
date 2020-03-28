package com.dxs.fms.vo;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:11
 */
public class AddPositionVo {
    private String positionName;
    private String positionNickname;
    private String positionCode;
    private String creatorId;
    private String companyName;

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionNickname() {
        return positionNickname;
    }

    public void setPositionNickname(String positionNickname) {
        this.positionNickname = positionNickname;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "AddPositionVo{" +
                "positionName='" + positionName + '\'' +
                ", positionNickname='" + positionNickname + '\'' +
                ", positionCode='" + positionCode + '\'' +
                ", creatorId='" + creatorId + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}

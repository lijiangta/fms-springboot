package com.dxs.fms.vo;

/**
 * @author dxs
 * @date 2020/3/27 0027 14:32
 */
public class AddCompanyVo1 {
    private String companyName;
    private String companyCode;
    private Integer creatorId;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public String toString() {
        return "AddCompanyVo1{" +
                "companyName='" + companyName + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", creatorId='" + creatorId + '\'' +
                '}';
    }
}

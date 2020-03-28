package com.dxs.fms.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:14
 */
public class AddDepartmentVo {
    private String companyName;
    private String deptRealName;
    private String deptNickname;
    private Short deptCode;
    private Integer deptManagerId;
    private Integer creatorId;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDeptRealName() {
        return deptRealName;
    }

    public void setDeptRealName(String deptRealName) {
        this.deptRealName = deptRealName;
    }

    public String getDeptNickname() {
        return deptNickname;
    }

    public void setDeptNickname(String deptNickname) {
        this.deptNickname = deptNickname;
    }

    public Short getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(Short deptCode) {
        this.deptCode = deptCode;
    }

    public Integer getDeptManagerId() {
        return deptManagerId;
    }

    public void setDeptManagerId(Integer deptManagerId) {
        this.deptManagerId = deptManagerId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public String toString() {
        return "AddDepartmentVo{" +
                "companyName='" + companyName + '\'' +
                ", deptRealName='" + deptRealName + '\'' +
                ", deptNickname='" + deptNickname + '\'' +
                ", deptCode=" + deptCode +
                ", deptManagerId=" + deptManagerId +
                ", creatorId=" + creatorId +
                '}';
    }
}

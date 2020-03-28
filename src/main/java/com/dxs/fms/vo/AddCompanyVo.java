package com.dxs.fms.vo;

import com.dxs.fms.annotation.CreateTime;

import java.util.Date;

/**
 * @author dxs
 * @date 2020/3/27 0027 13:54
 */
public class AddCompanyVo {
    private String companyName;
    private String companyCode;
    private Integer creatorId;
    @CreateTime
    private Date createTime;
    private Integer del;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "AddCompanyVo{" +
                "companyName='" + companyName + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", creatorId=" + creatorId +
                ", createTime=" + createTime +
                ", del=" + del +
                '}';
    }
}

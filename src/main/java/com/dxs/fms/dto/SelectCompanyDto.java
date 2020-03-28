package com.dxs.fms.dto;

/**
 * @author dxs
 * @date 2020/3/27 0027 15:23
 */
public class SelectCompanyDto {
    private Integer companyId;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "SelectCompanyDto{" +
                "companyId=" + companyId +
                '}';
    }
}

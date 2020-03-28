package com.dxs.fms.dto;

import com.dxs.fms.annotation.CreateTime;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author dxs
 * @date 2020/3/28 0028 14:46
 */
public class AddSeuDto {
    private Integer companyId;
    private Integer departmentId;
    private Integer positionId;
    private Integer employeeId;
    private Integer creatorId;
    @CreateTime
    private Date creatorTime;
    private Integer del;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreatorTime() {
        return creatorTime;
    }

    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "AddSeuDto{" +
                "companyId=" + companyId +
                ", departmentId=" + departmentId +
                ", positionId=" + positionId +
                ", employeeId=" + employeeId +
                ", creatorId=" + creatorId +
                ", creatorTime=" + creatorTime +
                ", del=" + del +
                '}';
    }
}

package com.dxs.fms.dto;

import com.dxs.fms.annotation.CreateTime;

import java.util.Date;

/**
 * @author dxs
 * @date 2020/3/27 0027 14:50
 */
public class AddDepartmentDto {
    /**
     * 2020/3/27
     * 公司id
     */
    private Integer companyId;
    /**
     * 部门负责人id
     */
    private Integer deptManagerId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 部门代码
     */
    private Short deptCode;
    /**
     * 部门别名
     */
    private String deptNickname;
    /**
     * 创建者id
     */
    private Integer creatorId;
    /**
     * 创建时间
     */
    @CreateTime
    private Date createTime;
    /**
     * 部门是否存在（0存在，1不存在）
     */
    private Integer del;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getDeptManagerId() {
        return deptManagerId;
    }

    public void setDeptManagerId(Integer deptManagerId) {
        this.deptManagerId = deptManagerId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Short getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(Short deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptNickname() {
        return deptNickname;
    }

    public void setDeptNickname(String deptNickname) {
        this.deptNickname = deptNickname;
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
        return "AddDepartmentDto{" +
                "companyId=" + companyId +
                ", deptManagerId=" + deptManagerId +
                ", deptName='" + deptName + '\'' +
                ", deptCode=" + deptCode +
                ", deptNickname='" + deptNickname + '\'' +
                ", creatorId=" + creatorId +
                ", createTime=" + createTime +
                ", del=" + del +
                '}';
    }
}

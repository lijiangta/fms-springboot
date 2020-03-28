package com.dxs.fms.dto;

import java.util.Date;

/**
 * @author dxs
 * @date 2020/3/28 0028 14:03
 */
public class AddEmployeeDto {
    /**
     * 2020/3/27
     * 公司id
     */
    private Integer companyId;
    /**
     * 员工的职位名称
     */
    private String employeePositionName;
    /**
     * 员工真实名称
     */
    private String employeeRealName;
    /**
     * 员工别名
     */
    private String employeeNickname;
    /**
     * 员工性别（0女1男）
     */
    private Integer gender;
    /**
     * 创建者id
     */
    private Integer creatorId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 员工是否在职（0在职1离职）
     */
    private Integer del;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getEmployeePositionName() {
        return employeePositionName;
    }

    public void setEmployeePositionName(String employeePositionName) {
        this.employeePositionName = employeePositionName;
    }

    public String getEmployeeRealName() {
        return employeeRealName;
    }

    public void setEmployeeRealName(String employeeRealName) {
        this.employeeRealName = employeeRealName;
    }

    public String getEmployeeNickname() {
        return employeeNickname;
    }

    public void setEmployeeNickname(String employeeNickname) {
        this.employeeNickname = employeeNickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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
        return "AddEmployeeDto{" +
                "companyId=" + companyId +
                ", employeePositionName='" + employeePositionName + '\'' +
                ", employeeRealName='" + employeeRealName + '\'' +
                ", employeeNickname='" + employeeNickname + '\'' +
                ", gender=" + gender +
                ", creatorId=" + creatorId +
                ", createTime=" + createTime +
                ", del=" + del +
                '}';
    }
}

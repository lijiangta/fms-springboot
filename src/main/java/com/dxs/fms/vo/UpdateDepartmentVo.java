package com.dxs.fms.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:15
 */

public class UpdateDepartmentVo {
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
     * 部门管理者
     */
    private Integer deptManagerId;

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

    public Integer getDeptManagerId() {
        return deptManagerId;
    }

    public void setDeptManagerId(Integer deptManagerId) {
        this.deptManagerId = deptManagerId;
    }

    @Override
    public String toString() {
        return "UpdateDepartmentVo{" +
                "deptName='" + deptName + '\'' +
                ", deptCode=" + deptCode +
                ", deptNickname='" + deptNickname + '\'' +
                ", deptManagerId=" + deptManagerId +
                '}';
    }
}

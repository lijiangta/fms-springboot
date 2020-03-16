package com.dxs.fms.dto;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:36
 */
public class DepartmentDto {
    private String deptRealName;
    private String deptNickname;
    private String deptManagerName;
    private String deptManagerId;

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

    public String getDeptManagerName() {
        return deptManagerName;
    }

    public void setDeptManagerName(String deptManagerName) {
        this.deptManagerName = deptManagerName;
    }

    public String getDeptManagerId() {
        return deptManagerId;
    }

    public void setDeptManagerId(String deptManagerId) {
        this.deptManagerId = deptManagerId;
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "deptRealName='" + deptRealName + '\'' +
                ", deptNickname='" + deptNickname + '\'' +
                ", deptManagerName='" + deptManagerName + '\'' +
                ", deptManagerId='" + deptManagerId + '\'' +
                '}';
    }
}

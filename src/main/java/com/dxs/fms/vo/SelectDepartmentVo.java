package com.dxs.fms.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:15
 */

public class SelectDepartmentVo {
    private String deptRealName;
    private String deptNickname;
    private String deptCode;

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

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    @Override
    public String toString() {
        return "SelectDepartmentVo{" +
                "deptRealName='" + deptRealName + '\'' +
                ", deptNickname='" + deptNickname + '\'' +
                ", deptCode='" + deptCode + '\'' +
                '}';
    }
}

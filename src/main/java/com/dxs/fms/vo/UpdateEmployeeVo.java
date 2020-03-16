package com.dxs.fms.vo;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:14
 */
public class UpdateEmployeeVo {
    private String empRealName;

    public String getEmpRealName() {
        return empRealName;
    }

    public void setEmpRealName(String empRealName) {
        this.empRealName = empRealName;
    }

    @Override
    public String toString() {
        return "UpdateEmployeeVo{" +
                "empRealName='" + empRealName + '\'' +
                '}';
    }
}

package com.dxs.fms.vo;

import com.dxs.fms.annotation.CreateTime;

import java.io.Serializable;
import java.util.Date;


/**
 * @author dxs
 * @date 2020/3/8 0008 18:08
 */

public class AddUserVo implements Serializable {
    private String companyName;
    private String deptName;
    private String positionName;
    private String userRealName;
    private String userNickname;
    private String userPassword;
    private String gender;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "AddUserVo{" +
                "companyName='" + companyName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", positionName='" + positionName + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", gender=" + gender +
                '}';
    }
}

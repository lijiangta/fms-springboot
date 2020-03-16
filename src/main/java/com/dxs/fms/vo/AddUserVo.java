package com.dxs.fms.vo;

import com.dxs.fms.annotation.CreateTime;

import java.io.Serializable;
import java.util.Date;


/**
 * @author dxs
 * @date 2020/3/8 0008 18:08
 */

public class AddUserVo implements Serializable {
    private String userRealName;
    private String userNickname;
    private String userPassword;
    private boolean gender;
    @CreateTime
    private Date createTime;
    private boolean del;

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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "AddUserVo{" +
                "userRealName='" + userRealName + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", gender=" + gender +
                ", createTime=" + createTime +
                ", del=" + del +
                '}';
    }
}

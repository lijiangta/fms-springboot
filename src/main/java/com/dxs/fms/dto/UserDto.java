package com.dxs.fms.dto;

import java.util.Date;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:37
 */
public class UserDto {
    private String userRealName;
    private String userNickname;
    private String userPassword;

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

    @Override
    public String toString() {
        return "UserDto{" +
                "userRealName='" + userRealName + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}

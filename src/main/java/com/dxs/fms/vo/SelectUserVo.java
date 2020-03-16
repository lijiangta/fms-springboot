package com.dxs.fms.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:08
 */

public class SelectUserVo {
    private String userRealName;
    private String userNickname;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SelectUserVo{" +
                "userRealName='" + userRealName + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

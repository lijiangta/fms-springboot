package com.dxs.fms.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:09
 */
public class UpdateUserVo {
    private Integer userRealName;
    private Integer userNickname;
    private Integer password;

    public Integer getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(Integer userRealName) {
        this.userRealName = userRealName;
    }

    public Integer getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(Integer userNickname) {
        this.userNickname = userNickname;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UpdateUserVo{" +
                "userRealName=" + userRealName +
                ", userNickname=" + userNickname +
                ", password=" + password +
                '}';
    }
}

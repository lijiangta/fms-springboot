package com.dxs.fms.dto;

import java.util.Date;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:37
 */
public class UserDto {
    private String userRealName;
    private String userNickname;
    private Date createTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userRealName='" + userRealName + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

package com.dxs.fms.dto;

import com.dxs.fms.annotation.CreateTime;

import java.util.Date;

/**
 * @author dxs
 * @date 2020/3/28 0028 16:10
 */
public class AddUserDto {
    private Integer companyId;
    /**
     * 2020/3/28
     * 部门id
     */
    private Integer deptId;
    private String userRealName;
    private String userNickname;
    private String userPassword;
    private Integer gender;
    @CreateTime
    private Date createTime;
    private boolean del;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
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
}

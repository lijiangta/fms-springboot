package com.dxs.fms.vo;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:14
 */
public class AddEmployeeVo {
    private String companyName;
    private String realName;
    private String nickname;
    private String positionName;
    private String gender;
    private Integer creatorId;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public String toString() {
        return "AddEmployeeVo{" +
                "companyName='" + companyName + '\'' +
                ", realName='" + realName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", positionName='" + positionName + '\'' +
                ", gender='" + gender + '\'' +
                ", creatorId=" + creatorId +
                '}';
    }
}

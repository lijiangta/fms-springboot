package com.dxs.fms.dto;

import com.dxs.fms.annotation.CreateTime;

/**
 * @author dxs
 * @date 2020/3/27 0027 15:04
 */
public class AddPositionDto {
    /**
     * 2020/3/27
     * 公司id
     */
    private Integer companyId;
    /**
     * 职位代码
     */
    private String positionCode;
    /**
     * 职位的真实名称
     */
    private String positionRealName;
    /**
     * 职位的别名
     */
    private String positionNickname;
    /**
     * 创建时间
     */
    @CreateTime
    private Integer creatorTime;
    /**
     * 该职位是否删除（0否1是）
     */
    private Integer del;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionRealName() {
        return positionRealName;
    }

    public void setPositionRealName(String positionRealName) {
        this.positionRealName = positionRealName;
    }

    public String getPositionNickname() {
        return positionNickname;
    }

    public void setPositionNickname(String positionNickname) {
        this.positionNickname = positionNickname;
    }

    public Integer getCreatorTime() {
        return creatorTime;
    }

    public void setCreatorTime(Integer creatorTime) {
        this.creatorTime = creatorTime;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}

package com.dxs.fms.vo;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:12
 */
public class UpdatePositionVo {
    private String positionRealName;

    public String getPositionRealName() {
        return positionRealName;
    }

    public void setPositionRealName(String positionRealName) {
        this.positionRealName = positionRealName;
    }

    @Override
    public String toString() {
        return "UpdatePositionVo{" +
                "positionRealName='" + positionRealName + '\'' +
                '}';
    }
}

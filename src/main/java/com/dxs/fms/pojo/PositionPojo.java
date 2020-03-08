package com.dxs.fms.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/2/28 0028 23:15
 */
@Getter
@Setter
@ToString
public class PositionPojo {
    /**
     * 职位id
     */
    private Integer positionId;
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
    private Integer creatorTime;
    /**
     * 该职位是否删除（0否1是）
     */
    private Integer del;
}

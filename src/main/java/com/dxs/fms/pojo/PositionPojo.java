package com.dxs.fms.pojo;

import com.dxs.fms.annotation.CreateTime;

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
}

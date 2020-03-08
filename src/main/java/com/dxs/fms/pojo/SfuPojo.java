package com.dxs.fms.pojo;

import java.util.Date;

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
public class SfuPojo {
    /**
     * 标准文件单元(由某个seuId创建的标准文件单元)的id
     */
    private Integer sfuId;
    /**
     * 标准员工单元(在某个部门中具体职位的员工)的id
     */
    private Integer seuId;
    /**
     * 文件id
     */
    private Integer fileId;
    /**
     * 创建者id
     */
    private Integer creatorId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * sfu是否被删除（0否1是）
     */
    private Integer del;
}

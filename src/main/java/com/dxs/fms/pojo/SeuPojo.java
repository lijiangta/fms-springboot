package com.dxs.fms.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/2/28 0028 20:39
 */
@Getter
@Setter
@ToString
public class SeuPojo {
    /**
     * 标准员工单元(在某个部门中具体职位的员工)的id
     */
    private Integer seuId;
    /**
     * 部门id
     */
    private Integer deptId;
    /**
     * 员工id
     */
    private Integer empId;
    /**
     * 员工职位id
     */
    private Integer positionId;
    /**
     * 创建者id
     */
    private Integer creatorId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 该seu是否删除（0否1是）
     */
    private Integer del;
}

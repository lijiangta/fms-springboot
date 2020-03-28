package com.dxs.fms.pojo;

import com.dxs.fms.annotation.CreateTime;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/2/28 0028 20:13
 */
@Getter
@Setter
@ToString
public class DepartmentPojo {
    /**
     * 部门id
     */
    private Integer deptId;
    /**
     * 2020/3/27
     * 公司id
     */
    private Integer companyId;
    /**
     * 部门负责人id
     */
    private Integer deptManagerId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 部门代码
     */
    private Short deptCode;
    /**
     * 部门别名
     */
    private String deptNickname;
    /**
     * 创建者id
     */
    private Integer creatorId;
    /**
     * 创建时间
     */
    @CreateTime
    private Date createTime;
    /**
     * 部门是否存在（0存在，1不存在）
     */
    private Integer del;
}

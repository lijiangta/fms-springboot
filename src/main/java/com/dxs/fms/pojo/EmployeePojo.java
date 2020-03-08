package com.dxs.fms.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/2/28 0028 20:26
 */
@Getter
@Setter
@ToString
public class EmployeePojo {
    /**
     * 员工id
     */
    private Integer employeeId;
    /**
     * 员工的职位名称
     */
    private String employeePositionName;
    /**
     * 员工真实名称
     */
    private String employeeRealName;
    /**
     * 员工别名
     */
    private String employeeNickname;
    /**
     * 员工性别（0女1男）
     */
    private Integer gender;
    /**
     * 创建者id
     */
    private Integer creatorId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 员工是否在职（0在职1离职）
     */
    private Integer del;
}

package com.dxs.fms.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:14
 */
@Getter
@Setter
@ToString
public class AddDepartmentVo {
    private String deptRealName;
    private String deptNickname;
    private String deptCode;
    private Integer deptManagerId;
}

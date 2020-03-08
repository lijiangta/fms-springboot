package com.dxs.fms.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/2/28 0028 20:40
 */
@Getter
@Setter
@ToString
public class UserPojo1 {
    /**
     * 用户id
     */
    private Integer uId;
    /**
     * 用户真实姓名
     */
    private String userRealName;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 用户别名
     */
    private String userNickname;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 性别（0女1男）
     */
    private Integer gender;
    /**
     * 用户是否删除（0否1是）
     */
    private Integer del;
}

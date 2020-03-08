package com.dxs.fms.dao;

import com.dxs.fms.pojo.UserPojo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dxs
 * @date 2020/2/29 0029 0:39
 */
public interface UserDao extends JpaRepository<UserPojo,Integer> {
    /**
     * 根据username查询UserPojo对象
     * @param username 用户别名
     * @return UserPojo对象
     */
    UserPojo findByUsername(String username);
    /**
     * 根据username和password查询UserPojo对象
     * @param username 用户别名
     * @param password 用户密码
     * @return UserPojo对象
     */
    UserPojo findByUsernameAndPassword(String username, String password);
}

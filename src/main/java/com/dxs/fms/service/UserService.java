package com.dxs.fms.service;

import com.dxs.fms.dao.UserDao;
import com.dxs.fms.pojo.UserPojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dxs
 * @date 2020/2/29 0029 0:43
 */
@Service
public class UserService{
    /**
     * 用户业务层
     */
    @Autowired
    private UserDao userDao;

    public boolean isExist(String username) {
        UserPojo user = getByName(username);
        return null!=user;
    }

    public UserPojo getByName(String username) {
        return userDao.findByUsername(username);
    }

    public UserPojo get(String username, String password){
        return userDao.findByUsernameAndPassword(username, password);
    }

    public void add(UserPojo user) {
        userDao.save(user);
    }
}

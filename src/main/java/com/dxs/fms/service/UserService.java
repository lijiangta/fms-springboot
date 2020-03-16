package com.dxs.fms.service;

import com.dxs.fms.dao.UserDao;
import com.dxs.fms.dto.UserDto;
import com.dxs.fms.mapper.UserMapper;
import com.dxs.fms.pojo.UserPojo;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.ResponseBody;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddUserVo;
import com.dxs.fms.vo.SelectUserVo;
import com.dxs.fms.vo.UpdateUserVo;
import com.sun.org.apache.xml.internal.serializer.utils.Utils;
import com.sun.xml.bind.Util;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private UserMapper userMapper;

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

    /**
     * 注册用户
     * @param addUserVo 注册用户对象
     * @return 返回处理结果
     */
    public Result1<Integer> addUser(AddUserVo addUserVo){
        if(addUserVo == null){
            return new Result1<Integer>(false,-1);
        }
        Integer  result = userMapper.addrUser(addUserVo);
        return new Result1<Integer>(true,result);
    }

    /**
     * 用户登录时查询用户信息
     * @param selectUserVo 需要查询的用户
     * @return 返回处理结果
     */
    public Result1<UserDto> getUser(SelectUserVo selectUserVo) {
        List<UserDto> userDto = new ArrayList<>();
        if(selectUserVo == null){
            return new Result1<UserDto>(false, new UserDto(),new Error("登录的对象为null"));
        }
        userDto = userMapper.getUser(selectUserVo);
        if(userDto == null){
            return new Result1<UserDto>(false, new UserDto(), new Error("在数据库中未查询到指定对象"));
        }
        return new Result1<UserDto>(true, userDto.get(0));
    }

    /**
     * 基于用户真实姓名注销对应的用户
     * @param realName 真实姓名
     * @return 返回指定内容
     */
    public Result1<Integer> updateDelByRealName(String realName) {
        if(realName == null){
            return new Result1<Integer>(false,-1);
        }
        Integer result = userMapper.updateDelByRealName(realName);
        return new Result1<Integer>(true,result);
    }

    /**
     * 分页获取用户
     * @param page 当前页面
     * @param limit 一页展示用户数
     * @return 返回结果
     */
    public PageUtils<UserDto> getUserByPageAndLimit(Integer page, Integer limit) {
        if(page == null){
            page = 1;
        }
        if (limit == null){
            limit = 5;
        }
        Integer start = PageUtils.calculateStart(page, limit);
        Integer end = PageUtils.calculateEnd(page, limit);
        List<UserDto> userDtoList = userMapper.getPageUser(start, end);
        PageUtils<UserDto> pageUtils = new PageUtils<>();
        pageUtils.setCurrent(page);
        pageUtils.setLimit(limit);
        pageUtils.setDate(userDtoList);
        Integer total = userMapper.getAllUser();
        pageUtils.setTotal(total);
        return pageUtils;
    }

    /**
     * 基于需要修改的对象修改用户信息
     * @param updateUserVo 需要修改用户信息对象
     * @return 返回结果
     */
    public Result1<Integer> updateUserInfo(UpdateUserVo updateUserVo) {
        if(updateUserVo == null){
            return new Result1<Integer>(false,-1);
        }
        if(updateUserVo.getUserRealName() == null){
            return new Result1<Integer>(false,-1);
        }
        Integer result = userMapper.updateUserInfo(updateUserVo);
        return new Result1<Integer>(true,result);
    }
}

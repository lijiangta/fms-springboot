package com.dxs.fms.service.impl;

import com.dxs.fms.dto.AddUserDto;
import com.dxs.fms.dto.SelectCompanyDto;
import com.dxs.fms.dto.SelectDepartmentDto;
import com.dxs.fms.dto.UserDto;
import com.dxs.fms.mapper.CompanyMapper;
import com.dxs.fms.mapper.DepartmentMapper;
import com.dxs.fms.mapper.UserMapper;
import com.dxs.fms.service.UserService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.ResponseBody;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddUserVo;
import com.dxs.fms.vo.SelectUserVo;
import com.dxs.fms.vo.UpdateUserVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dxs
 * @date 2020/3/16 0016 10:42
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 用户业务层
     */

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 注册用户
     * @param addUserVo 注册用户对象
     * @return 返回处理结果
     */
    @Override
    public Result1<Integer> addUser(AddUserVo addUserVo){
        if(addUserVo == null){
            throw  new RuntimeException();
        }
        AddUserDto addUserDto = new AddUserDto();
        SelectCompanyDto selectCompanyDto = companyMapper.getCompanyId(addUserVo.getCompanyName());
        addUserDto.setCompanyId(selectCompanyDto.getCompanyId());
        SelectDepartmentDto selectDepartmentDto = departmentMapper.getDepartmentId(selectCompanyDto.getCompanyId(), addUserVo.getDeptName());
        addUserDto.setDeptId(selectDepartmentDto.getDeptId());
        addUserDto.setUserRealName(addUserVo.getUserRealName());
        addUserDto.setUserNickname(addUserVo.getUserNickname());
        if("女".equals(addUserVo.getGender())){
            addUserDto.setGender(0);
        }else if("男".equals(addUserVo.getGender())){
            addUserDto.setGender(1);
        }
        addUserDto.setDel(false);
        Integer  result = userMapper.addrUser(addUserDto);
        return new Result1<Integer>(true,result);
    }

    /**
     * 用户登录时查询用户信息
     * @param selectUserVo 需要查询的用户
     * @return 返回处理结果
     */
    @Override
    public Result1<UserDto> getUser(SelectUserVo selectUserVo) {
        List<UserDto> userDto = new ArrayList<>();
        if(selectUserVo == null){
            return new Result1<UserDto>(false, new UserDto(),new Error("登录的对象为null"));
        }
        userDto = userMapper.getUser(selectUserVo);
        if(userDto.isEmpty()){
            return new Result1<UserDto>(false, new UserDto(), new Error("在数据库中未查询到指定对象"));
        }
        return new Result1<UserDto>(true, userDto.get(0));
    }

    /**
     * 基于用户真实姓名注销对应的用户
     * @param realName 真实姓名
     * @return 返回指定内容
     */
    @Override
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
    @Override
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
    @Override
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

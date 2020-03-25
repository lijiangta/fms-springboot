package com.dxs.fms.service;

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
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dxs
 * @date 2020/2/29 0029 0:43
 */
public interface UserService{
    Result1<Integer> addUser(AddUserVo addUserVo);
    Result1<UserDto> getUser(SelectUserVo selectUserVo);
    Result1<Integer> updateDelByRealName(String realName);
    PageUtils<UserDto> getUserByPageAndLimit(Integer page, Integer limit);
    Result1<Integer> updateUserInfo(UpdateUserVo updateUserVo);
}

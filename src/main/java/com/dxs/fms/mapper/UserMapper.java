package com.dxs.fms.mapper;

import com.dxs.fms.dto.AddUserDto;
import com.dxs.fms.dto.UserDto;
import com.dxs.fms.sqlprovider.UserSqlProvider;
import com.dxs.fms.vo.AddUserVo;
import com.dxs.fms.vo.DeleteUserVo;
import com.dxs.fms.vo.SelectUserVo;
import com.dxs.fms.vo.UpdateUserVo;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 用户的数据映射层
 * @author dxs
 * @date 2020/3/8 0008 15:45
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 注册用户
     * @param addUserDto 前端传给后端的用户对象
     * @return 返回处理结果
     */
    @InsertProvider(type = UserSqlProvider.class, method = "addrUserSql")
    @Results(id = "AddUserDto", value = {
            @Result(column = "company_id", property = "companyId"),
            @Result(column = "dept_id", property = "deptId"),
            @Result(column = "user_realname", property = "userRealName"),
            @Result(column = "user_nickname", property = "userNickname"),
            @Result(column = "user_password", property = "userPassword"),
            @Result(column = "createtime", property = "createTime"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "del", property = "del")
    })
    Integer addrUser(AddUserDto addUserDto);

    /**
     * 查询用户
     * @param selectUserVo 前端传给后端的用户对象
     * @return 返回处理结果
     */
    @SelectProvider(type = UserSqlProvider.class, method = "getUserSql")
    @Results(id = "UserDto", value = {
            @Result(column = "user_realname", property = "userRealName"),
            @Result(column = "user_nickname", property = "userNickname"),
            @Result(column = "user_password", property = "userPassword"),
    })
    List<UserDto> getUser(SelectUserVo selectUserVo);

    /**
     * 更改用户信息
     * @param updateUserVo 前端传给后端的用户对象
     * @return 返回处理结果
     */
    @UpdateProvider(type = UserSqlProvider.class, method = "setUserSql")
    @Results(id = "UpdateUserVo", value = {
            @Result(column = "uid", property = "userId"),
    })
    Integer setUser(UpdateUserVo updateUserVo);

    /**
     * 删除用户信息
     * @param deleteUserVo 前端传给后端的用户对象
     * @return 返回处理结果
     */
    @DeleteProvider(type = UserSqlProvider.class, method = "delUserSql")
    @Results(id = "DeleteUserVo", value = {
            @Result(column = "uid", property = "userId"),
    })
    Integer delUser(DeleteUserVo deleteUserVo);


    /**
     * 基于真实信息注销指定用户
     * @param realName 真实姓名
     * @return 返回对象
     */
    @UpdateProvider(type = UserSqlProvider.class, method = "updateDelByRealNameSql")
    Integer updateDelByRealName(String realName);

    /**
     * 分页返回用户信息
     * @param start 开始的索引
     * @param end 结束的索引
     * @return 返回的结果
     */
    @SelectProvider(type = UserSqlProvider.class, method = "getPageUserSql")
    @ResultMap("UserDto")
    List<UserDto> getPageUser(Integer start, Integer end);

    /**
     * 获取所有用户数
     * @return 返回结果
     */
    @SelectProvider(type = UserSqlProvider.class, method = "getAllUserSql")
    Integer getAllUser();

    /**
     * 基于需要修改的用户信息修改用户信息
     * @param updateUserVo 需要修改的用户信息对象
     * @return 返回结果
     */
    @UpdateProvider(type = UserSqlProvider.class, method = "updateUserInfoSql")
    Integer updateUserInfo(UpdateUserVo updateUserVo);
}

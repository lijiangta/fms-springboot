package com.dxs.fms.sqlprovider;

import com.dxs.fms.vo.AddUserVo;
import com.dxs.fms.vo.DeleteUserVo;
import com.dxs.fms.vo.SelectUserVo;
import com.dxs.fms.vo.UpdateUserVo;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

import javax.validation.constraints.NotNull;

import jdk.nashorn.internal.objects.annotations.Where;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:24
 */
public class UserSqlProvider {
    public String addrUserSql(AddUserVo addUserVo){
        //"insert into dxs_user(user_realname, user_nickname, user_password, gender) values(#{}, #{}, #{}, #{})"
        return new SQL()
                .INSERT_INTO("dxs_user")
                .INTO_COLUMNS("user_realname", "user_nickname", "user_password", "gender", "createtime", "del")
                .INTO_VALUES("#{userRealName}","#{userNickname}","#{userPassword}","#{gender}","#{createTime}","#{del}")
                .toString();
    }
    public String getUserSql(SelectUserVo selectUserVo){
        //"select user_realname from dxs_user u where u.user_nickname = #{userRealName}"
        //"select user_realname from dxs_user u where u.user_nickname = #{userNickname}"
        return new SQL(){
            {
                SELECT("user_realname, user_nickname")
                        .FROM("dxs_user");
                        if(selectUserVo.getUserRealName() != null) WHERE("user_realname = #{userRealName} and del = 0");
                        if(selectUserVo.getUserNickname() != null) WHERE("user_nickname = #{userNickname} and del = 0");
            }
        }
        .toString();
    }
    public String setUserSql(UpdateUserVo updateUserVo){
        //"update dxs_user set password = #{} where uid = #{}"
        return new SQL(){
            {
                UPDATE("dxs_user")
                        .SET("password = #{password}")
                        .WHERE("uid = #{uid}");
            }
        }

                .toString();
    }
    public String delUserSql(DeleteUserVo deleteUserVo){
        //"delete from dxs_user where uid = #{}"
        return new SQL(){
            {
                DELETE_FROM("dxs_user")
                        .WHERE("uid = #{uid}");
            }
        }.toString();
    }

    public String updateDelByRealNameSql(String realName){
        return new SQL(){
            {
                UPDATE("dxs_user")
                        .SET("del = 1")
                        .WHERE("user_realname = #{realName}");
            }
        }.toString();
    }


    public String getPageUserSql(Integer start, Integer end){
        return new SQL(){
            {
                SELECT("user_realname, user_nickname, createTime")
                        .FROM("dxs_user")
                        .LIMIT("#{start}, #{end}");
            }
        }.toString();
    }

    public String getAllUserSql(){
        return new SQL(){
            {
                SELECT("count(*) as total")
                        .FROM("dxs_user");
            }
        }.toString();
    }

    public String updateUserInfoSql(UpdateUserVo updateUserVo){
        return new SQL(){
            {
                UPDATE("dxs_user");
                if(updateUserVo.getUserNickname() != null) SET("user_nickname = #{updateUserVo.getUserNickname()}");
                if(updateUserVo.getPassword() != null) SET("password = #{updateUserVo.getPassword()}");
                WHERE("user_realname = #{updateUserVo.getUserNickname()} and del = 0");
            }
        }.toString();
    }
}

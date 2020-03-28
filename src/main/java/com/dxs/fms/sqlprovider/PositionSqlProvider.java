package com.dxs.fms.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:26
 */
public class PositionSqlProvider {
    public String addPositionSql(){
        //"insert into dxs_position(position_realname, position_nickname, position_code, creator_id) values(#{}, #{}, #{}, #{})"
        return new SQL(){
            {
                INSERT_INTO("dxs_position")
                        .INTO_COLUMNS("company_id","position_realname", "position_nickname", "position_code", "creator_id","create_time","del")
                        .INTO_VALUES("#{companyId}","#{positionRealname}", "#{positionNickname}", "#{positionCode}", "#{creatorId}","#{createTime}","#{del}");
            }
        }.toString();
    }
    public String getPosition(){
        //"select * from dxs_position where "
        return new SQL(){
            {
                SELECT("position_realname")
                        .FROM("dxs_position")
                        .WHERE("position_realname = #{positionRealName}");
            }
        }.toString();
    }
    public String setPosition(){
        //"update dxs_position set position_nickname = #{} where position_realname = #{} and postion_code = #{}"
        return new SQL(){
            {
                UPDATE("dxs_position")
                        .SET("position_nickname = #{positionNickname}")
                        .WHERE("position_realname = #{positionRealNme}");
            }
        }.toString();
    }
    public String delPosition(){
        //"delete from dxs_position where position_id = #{}"
        return new SQL(){
            {
                DELETE_FROM("dxs_position")
                        .WHERE("position_realname = #{positionRealName}");
            }
        }.toString();
    }
}

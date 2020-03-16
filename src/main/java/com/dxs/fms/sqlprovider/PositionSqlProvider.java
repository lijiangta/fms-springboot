package com.dxs.fms.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:26
 */
public class PositionSqlProvider {
    public String addPosition(){
        //"insert into dxs_position(position_realname, position_nickname, position_code, creator_id) values(#{}, #{}, #{}, #{})"
        return new SQL(){
            {
                INSERT_INTO("dxs_position")
                        .INTO_COLUMNS("position_realname", "position_nickname", "position_code", "creator_id")
                        .INTO_VALUES("#{position_realname}", "#{position_nickname}", "#{position_code}", "#{creator_id}");
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

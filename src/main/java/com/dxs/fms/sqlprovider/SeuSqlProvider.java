package com.dxs.fms.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:25
 */
public class SeuSqlProvider {
    public String addSeu(){
        //"insert into dxs_seu() values()"
        return new SQL(){
            {
                INSERT_INTO("dxs_seu")
                        .INTO_COLUMNS("dept_id", "emp_id", "position_id", "creator_id")
                        .INTO_VALUES("#{deptId}", "#{empId}", "#{positionId}", "#{creatorId}");
            }
        }.toString();
    }
    public String getSeu(){
        //"select * from dxs_seu where "
        return new SQL(){
            {
                SELECT("position_id")
                        .FROM("dxs_seu")
                        .WHERE("seu_id = #{seuId}");
            }
        }.toString();
    }
    public String setSeu(){
        //"update dxs_seu set  where "
        return new SQL(){
            {
                UPDATE("dxs_seu")
                        .SET("position_id = #{positionId}")
                        .WHERE("seu_id = #{seuId}");
            }
        }.toString();
    }
    public String delSeu(){
        //"delete from dxs_seu where "
        return new SQL(){
            {
                DELETE_FROM("dxs_seu")
                        .WHERE("seu_id = #{seuId}");
            }
        }.toString();
    }
}

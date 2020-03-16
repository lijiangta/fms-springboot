package com.dxs.fms.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:25
 */
public class SfuSqlProvider {
    public String addSfu(){
        //"insert into dxs_sfu() values()"
        return new SQL(){
            {
                INSERT_INTO("dxs_sfu")
                        .INTO_COLUMNS("seu_id", "file_id", "creator_id")
                        .INTO_VALUES("#{seuId}", "#{fileId}", "#{creatorId}");
            }
        }.toString();
    }
    public String getSfu(){
        //"select * from dxs_sfu where "
        return new SQL(){
            {
                SELECT("file_id")
                        .FROM("dxs_sfu")
                        .WHERE("seu_id = #{seuId}");
            }
        }.toString();
    }
    public String setSfu(){
        //"update dxs_sfu set  where "
        return new SQL(){
            {
                UPDATE("dxs_sfu")
                        .SET("del = #{del}")
                        .WHERE("seu_id = #{seuId}  and file_id = #{fileId}");
            }
        }.toString();
    }
    public String delSfu(){
        //"delete from dxs_sfu where "
        return new SQL(){
            {
                DELETE_FROM("dxs_sfu")
                        .WHERE("seu_id = #{seuId}  and file_id = #{fileId}");
            }
        }.toString();
    }
}

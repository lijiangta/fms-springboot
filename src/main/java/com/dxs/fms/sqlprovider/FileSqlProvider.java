package com.dxs.fms.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:26
 */
public class FileSqlProvider {
    public String addFile(){
        //"insert into dxs_file(file_name, file_suffix, creator_id) values(#{}, #{}, #{})"
        return new SQL(){
            {
                INSERT_INTO("dxs_file")
                        .INTO_COLUMNS("file_name", "file_suffix", "creator_id")
                        .INTO_VALUES("#{file_name}", "#{file_suffix}", "#{creator_id}");
            }
        }.toString();
    }
    public String getFile(){
        //"select * from dxs_file where file_name like $#{}$"
        return new SQL(){
            {
                SELECT("file_name")
                        .FROM("dxs_file")
                        .WHERE("file_name like #{fileName}");
            }
        }.toString();
    }
    public String setFile(){
        //"update dxs_file set file_name = #{} where creator_id = #{}"
        return new SQL(){
            {
                UPDATE("dxs_file")
                        .SET("file_name = #{fileName}")
                        .WHERE("creator_id = #{createId}");
            }
        }.toString();
    }
    public String delFile(){
        //"delete from dxs_file where file_name = #{} and creator_id = #{}"
        return new SQL(){
            {
                DELETE_FROM("dxs_file")
                        .WHERE("file_name = #{fileName} and creator_id = #{creatorId}");
            }
        }.toString();
    }
}

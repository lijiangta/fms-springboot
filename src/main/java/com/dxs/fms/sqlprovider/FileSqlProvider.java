package com.dxs.fms.sqlprovider;

import com.dxs.fms.vo.AddFileVo;
import com.dxs.fms.vo.DeleteFileVo;
import com.dxs.fms.vo.SelectFileVo;
import com.dxs.fms.vo.UpdateFileVo;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:26
 */
public class FileSqlProvider {
    public String addFile(AddFileVo addFile){
        //"insert into dxs_file(file_name, file_suffix, creator_id) values(#{}, #{}, #{})"
        return new SQL(){
            {
                INSERT_INTO("dxs_file")
                        .INTO_COLUMNS("file_name", "file_suffix", "creator_id")
                        .INTO_VALUES("#{file_name}", "#{file_suffix}", "#{creator_id}");
            }
        }.toString();
    }
    public String getFile(SelectFileVo selectFile){
        //"select * from dxs_file where file_name like $#{}$"
        return new SQL(){
            {
                SELECT("file_name")
                        .FROM("dxs_file")
                        .WHERE("file_name like #{fileName}");
            }
        }.toString();
    }
    public String setFile(UpdateFileVo updateFileVo){
        //"update dxs_file set file_name = #{} where creator_id = #{}"
        return new SQL(){
            {
                UPDATE("dxs_file")
                        .SET("file_name = #{fileName}")
                        .WHERE("creator_id = #{createId}");
            }
        }.toString();
    }
    public String delFile(DeleteFileVo deleteFile){
        //"delete from dxs_file where file_name = #{} and creator_id = #{}"
        return new SQL(){
            {
                DELETE_FROM("dxs_file")
                        .WHERE("file_name = #{fileName} and creator_id = #{creatorId}");
            }
        }.toString();
    }

    public String listFileByUserRealNameSql(String realName){
        return new SQL(){
            {
                //select f.file_realname from dxs_file f inner join dxs_sfu where sfu.file_id = f.file_id inner join dxs_user u where u.user_realname = 'admin';
                //select f.file_realname from dxs_file f inner join dxs_sfu sfu where sfu.file_id = f.file_id inner join dxs_seu seu where seu.seu_id = sfu.seu_id and seu.emp_id = select emp.id from dxs_employee emp where employee_realname = 'dxs';

//                SELECT
//                file.file_name,
//                        sfu.seu_id
//                FROM
//                dxs_file file
//                INNER JOIN dxs_sfu sfu ON sfu.file_id = file.file_id
//                INNER JOIN dxs_seu seu ON seu.seu_id = sfu.sfu_id
//                WHERE
//                seu.emp_id = ( SELECT emp.employee_id FROM dxs_employee emp WHERE emp.employee_realname = 'dxs' );
                SELECT("file.file_name,file.file_suffix")
                        .FROM("dxs_file file")
                        .INNER_JOIN("dxs_sfu sfu ON sfu.file_id = file.file_id")
                        .INNER_JOIN("dxs_seu seu ON seu.seu_id = sfu.sfu_id")
                        .WHERE("seu.emp_id = ( SELECT emp.employee_id FROM dxs_employee emp WHERE emp.employee_realname = #{realName} )");
            }
        }.toString();
    }
}

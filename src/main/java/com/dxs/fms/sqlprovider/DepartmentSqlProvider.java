package com.dxs.fms.sqlprovider;

import com.dxs.fms.vo.AddDepartmentVo;
import com.dxs.fms.vo.DeleteDepartmentVo;
import com.dxs.fms.vo.SelectDepartmentVo;
import com.dxs.fms.vo.UpdateDepartmentVo;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:25
 */
public class DepartmentSqlProvider {
    public String addDepartmentSql(AddDepartmentVo departmentVo){
        //"insert into dxs_department(dept_name, dept_nickname, dept_code, dept_manager_id, creator_id) values(#{}, #{}, #{}, #{}, #{})"
        return new SQL(){
            {
                INSERT_INTO("dxs_department d")
                        .INTO_COLUMNS("company_id","dept_name", "dept_nickname", "dept_code", "dept_manager_id", "creator_id", "create_time", "del")
                        .INTO_VALUES("#{companyId}","#{deptName}", "#{deptNickname}", "#{deptCode}", "#{deptManagerId}", "#{creatorId}","#{createTime}","#{del}");
            }
        }.toString();
    }
    public String getDepartmentSql(SelectDepartmentVo selectDepartmentVo){
        //"select * from dxs_department where "
        return new SQL(){
            {
                SELECT("dept_realname")
                        .FROM("dxs_dept");
                        if(selectDepartmentVo.getDeptRealName() == null) WHERE("dept_realname = #{deptRealName}");
                        if(selectDepartmentVo.getDeptCode() == null) WHERE("dept_code = #{deptCode}");
            }
        }.toString();
    }
    public String setDepartment(UpdateDepartmentVo updateDepartmentVo){
        //"update dxs_department set dept_manager_id where dept_name = #{}"
        return new SQL(){
            {
                UPDATE("dxs_department")
                        .SET("dept_nickname = #{deptNickname}")
                        .WHERE("dept_code = #{deptCode}");
            }
        }.toString();
    }
    public String delDepartment(DeleteDepartmentVo deleteDepartmentVo){
        //"delete from dxs_department where dept_name = #{} and dept_code = #{}"
        return new SQL(){
            {
                DELETE_FROM("dxs_department")
                        .WHERE("dept_code = #{deptCode}");
            }
        }.toString();
    }

    public String updateDelByRealNameSql(String realName){
        return new SQL(){
            {}
        }.toString();
    }

    public String updateInfoSql(UpdateDepartmentVo updateDepartmentVo){
        return new SQL(){
            {}
        }.toString();
    }

    public String getPageByPageAndLimitSql(Integer start, Integer end){
        return new SQL(){
            {}
        }.toString();
    }

    public String getAllSql(){
        return new SQL(){
            {}
        }.toString();
    }

    public String getPositionIdSql(Integer companyId, String positionName){
        return new SQL(){
            {
                SELECT("position_id");
                FROM("dxs_position");
                WHERE("company_id = #{companyId} and position_realname = #{positionName}");
            }
        }.toString();
    }

    public String getDepartmentIdSql(Integer companyId, String deptName){
        return new SQL(){
            {
                SELECT("department_id");
                FROM("dxs_department");
                WHERE("company_id = #{companyId} and department_realname = #{deptName}");
            }
        }.toString();
    }
}

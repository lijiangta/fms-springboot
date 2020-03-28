package com.dxs.fms.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author dxs
 * @date 2020/3/8 0008 18:25
 */
public class EmployeeSqlProvider {
    public String addEmployee(){
        //"insert into dxs_employee(employee_realname, employee_position, employee_nickname, gender, creator_id) values(#{}, #{}, #{}, #{}, #{})"
        return new SQL(){
            {
                INSERT_INTO("dxs_employee")
                        .INTO_COLUMNS("employee_realname", "employee_position", "employee_nickname", "gender", "creator_id")
                        .INTO_VALUES("#{employeeRealName}", "#{employeePosition}", "#{employeeNickname}", "#{gender}", "#{creatorId}");
            }
        }.toString();
    }
    public String getEmployee(){
        //"select * from dxs_employee where employee_realname = #{}"
        return new SQL(){
            {
                SELECT("employee_realname")
                        .FROM("dxs_employee")
                        .WHERE("dept_realname = #{deptRealName}");
            }
        }.toString();
    }
    public String setEmployee(){
        //"update dxs_employee set employee_position_name where employee_id = #{}"
        return new SQL(){
            {
                UPDATE("dxs_employee")
                        .SET("employee_nickname = #{employeeNickname}")
                        .WHERE("employee_realname = #{employeeRealName}");
            }
        }.toString();
    }
    public String delEmployee(){
        //"delete from dxs_employee where employee_id = #{}"
        return new SQL(){
            {
                DELETE_FROM("dxs_employee")
                        .WHERE("employee_realname = #{employeeRealName}");
            }
        }.toString();
    }

    public String getEmployeeIdSql(Integer companyId, String empName){
        return new SQL(){
            {
                SELECT("employee_id");
                FROM("dxs_employee");
                WHERE("company_id = #{companyId} and employee_realname = #{empName}");
            }
        }.toString();
    }
}

package com.dxs.fms.mapper;
/**
 * @author dxs
 * @date 2020/3/8 0008 17:37
 */

import com.dxs.fms.dto.AddEmployeeDto;
import com.dxs.fms.dto.DepartmentDto;
import com.dxs.fms.dto.EmployeeDto;
import com.dxs.fms.dto.SelectEmployeeDto;
import com.dxs.fms.sqlprovider.EmployeeSqlProvider;
import com.dxs.fms.vo.AddEmployeeVo;
import com.dxs.fms.vo.DeleteDepartmentVo;
import com.dxs.fms.vo.DeleteEmployeeVo;
import com.dxs.fms.vo.SelectEmployeeVo;
import com.dxs.fms.vo.UpdateDepartmentVo;
import com.dxs.fms.vo.UpdateEmployeeVo;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface EmployeeMapper {
    @InsertProvider(type = EmployeeSqlProvider.class, method = "addEmployee")
    @Results(id = "AddEmployeeDto",value = {
            @Result(column = "employee_realname",property = "employeeRealName"),
            @Result(column = "employee_nickname",property = "employeeNickname"),
            @Result(column = "employee_company_id",property = "employeeCompanyId"),
            @Result(column = "employee_position_name",property = "employeePositionName"),
            @Result(column = "gender",property = "gender"),
            @Result(column = "create_id",property = "createId"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "del",property = "del"),
    })
    public Integer addEmployee(AddEmployeeDto addEmployeeDto);

    @SelectProvider(type = EmployeeSqlProvider.class, method = "getEmployee")
    public EmployeeDto getEmployee(SelectEmployeeVo selectEmployeeVo);

    @UpdateProvider(type = EmployeeSqlProvider.class, method = "setEmployee")
    public Integer setEmployee(UpdateEmployeeVo updateEmployeeVo);

    @DeleteProvider(type = EmployeeSqlProvider.class, method = "delEmployee")
    public Integer delEmployee(DeleteEmployeeVo deleteEmployeeVo);

    Integer updateDelByRealName(String realName);

    Integer updateInfo(UpdateEmployeeVo updateEmployeeVo);

    List<EmployeeDto> getPageByPageAndLimit(Integer start, Integer end);

    Integer getAll();

    @SelectProvider(type = EmployeeSqlProvider.class, method = "getEmployeeIdSql")
    SelectEmployeeDto getEmployeeId(Integer companyId, String empName);
}

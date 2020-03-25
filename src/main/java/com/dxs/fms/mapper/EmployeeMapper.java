package com.dxs.fms.mapper;
/**
 * @author dxs
 * @date 2020/3/8 0008 17:37
 */

import com.dxs.fms.dto.DepartmentDto;
import com.dxs.fms.dto.EmployeeDto;
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
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface EmployeeMapper {
    @InsertProvider(type = EmployeeSqlProvider.class, method = "addEmployee")
    public Integer addEmployee(AddEmployeeVo employeeVo);

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
}

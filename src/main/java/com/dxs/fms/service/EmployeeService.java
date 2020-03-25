package com.dxs.fms.service;

import com.dxs.fms.dto.DepartmentDto;
import com.dxs.fms.dto.EmployeeDto;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddDepartmentVo;
import com.dxs.fms.vo.AddEmployeeVo;
import com.dxs.fms.vo.SelectDepartmentVo;
import com.dxs.fms.vo.SelectEmployeeVo;
import com.dxs.fms.vo.UpdateDepartmentVo;
import com.dxs.fms.vo.UpdateEmployeeVo;

import org.springframework.stereotype.Service;

/**
 * @author dxs
 * @date 2020/3/16 0016 14:01
 */
public interface EmployeeService {
    Result1<Integer> add(AddEmployeeVo addEmployeeVo);

    Result1<Integer> updateDelByRealName(String realName);

    Result1<Integer> updateInfo(UpdateEmployeeVo updateEmployeeVo);

    PageUtils<EmployeeDto> getPageByPageAndLimit(Integer page, Integer limit);

    Result1<EmployeeDto> get(SelectEmployeeVo selectEmployeeVo);
}

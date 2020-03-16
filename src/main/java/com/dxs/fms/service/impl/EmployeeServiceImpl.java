package com.dxs.fms.service.impl;

import com.dxs.fms.dto.DepartmentDto;
import com.dxs.fms.dto.EmployeeDto;
import com.dxs.fms.mapper.DepartmentMapper;
import com.dxs.fms.mapper.EmployeeMapper;
import com.dxs.fms.service.EmployeeService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddDepartmentVo;
import com.dxs.fms.vo.AddEmployeeVo;
import com.dxs.fms.vo.SelectDepartmentVo;
import com.dxs.fms.vo.SelectEmployeeVo;
import com.dxs.fms.vo.UpdateDepartmentVo;
import com.dxs.fms.vo.UpdateEmployeeVo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author dxs
 * @date 2020/3/16 0016 14:01
 */
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Result1<Integer> add(AddEmployeeVo addEmployeeVo) {
        if(addEmployeeVo == null){
            return new Result1<Integer>(false,-1);
        }
        Integer  result = employeeMapper.addEmployee(addEmployeeVo);
        return new Result1<Integer>(true,result);
    }

    @Override
    public Result1<Integer> updateDelByRealName(String realName) {
        if(realName == null){
            return new Result1<>(false,-1);
        }
        return new Result1<>(true,employeeMapper.updateDelByRealName(realName));
    }

    @Override
    public Result1<Integer> updateInfo(UpdateEmployeeVo updateEmployeeVo) {
        if(updateEmployeeVo == null || updateEmployeeVo.getEmpRealName() == null) return new Result1<>(false, -1);
        return new Result1<>(true, employeeMapper.updateInfo(updateEmployeeVo));
    }

    @Override
    public PageUtils<EmployeeDto> getPageByPageAndLimit(Integer page, Integer limit) {
        if(page == null || limit == null) {
            page = 1;
            limit = 5;
        }
        Integer start = PageUtils.calculateStart(page, limit);
        Integer end = PageUtils.calculateEnd(page, limit);
        List<EmployeeDto> employeeDtoList = employeeMapper.getPageByPageAndLimit(start, end);
        Integer total = employeeMapper.getAll();
        PageUtils<EmployeeDto> pageUtils = new PageUtils<>();
        pageUtils.setTotal(total);
        pageUtils.setDate(employeeDtoList);
        return pageUtils;
    }

    @Override
    public Result1<EmployeeDto> get(SelectEmployeeVo selectEmployeeVo) {
        if(selectEmployeeVo == null) return new Result1<>(false, new EmployeeDto());
        return new Result1<>(true, employeeMapper.getEmployee(selectEmployeeVo));
    }
}

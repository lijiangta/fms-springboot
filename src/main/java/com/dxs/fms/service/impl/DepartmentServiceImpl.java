package com.dxs.fms.service.impl;

import com.dxs.fms.dto.DepartmentDto;
import com.dxs.fms.dto.UserDto;
import com.dxs.fms.mapper.DepartmentMapper;
import com.dxs.fms.service.DepartmentService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddDepartmentVo;
import com.dxs.fms.vo.SelectDepartmentVo;
import com.dxs.fms.vo.UpdateDepartmentVo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author dxs
 * @date 2020/3/16 0016 10:42
 */
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Result1<Integer> add(AddDepartmentVo addDepartmentVo) {
        if(addDepartmentVo == null){
            return new Result1<Integer>(false,-1);
        }
        Integer  result = departmentMapper.addDepartment(addDepartmentVo);
        return new Result1<Integer>(true,result);
    }

    @Override
    public Result1<Integer> updateDelByRealName(String realName) {
        if(realName == null){
            return new Result1<>(false,-1);
        }
        return new Result1<>(true,departmentMapper.updateDelByRealName(realName));
    }

    @Override
    public Result1<Integer> updateInfo(UpdateDepartmentVo updateDepartmentVo) {
        if(updateDepartmentVo == null || updateDepartmentVo.getDeptCode() == null) return new Result1<>(false, -1);
        return new Result1<>(true, departmentMapper.updateInfo(updateDepartmentVo));
    }

    @Override
    public PageUtils<DepartmentDto> getPageByPageAndLimit(Integer page, Integer limit) {
        if(page == null || limit == null) {
            page = 1;
            limit = 5;
        }
        Integer start = PageUtils.calculateStart(page, limit);
        Integer end = PageUtils.calculateEnd(page, limit);
        List<DepartmentDto> departmentDtoList = departmentMapper.getPageByPageAndLimit(start, end);
        Integer total = departmentMapper.getAll();
        PageUtils<DepartmentDto> pageUtils = new PageUtils<>();
        pageUtils.setTotal(total);
        pageUtils.setDate(departmentDtoList);
        return pageUtils;
    }

    @Override
    public Result1<DepartmentDto> get(SelectDepartmentVo selectDepartmentVo) {
        if(selectDepartmentVo == null) return new Result1<>(false, new DepartmentDto());
        return new Result1<>(true, departmentMapper.getDepartment(selectDepartmentVo));
    }
}

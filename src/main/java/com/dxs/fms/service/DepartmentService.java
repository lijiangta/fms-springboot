package com.dxs.fms.service;

import com.dxs.fms.dto.DepartmentDto;
import com.dxs.fms.dto.UserDto;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddDepartmentVo;
import com.dxs.fms.vo.AddUserVo;
import com.dxs.fms.vo.SelectDepartmentVo;
import com.dxs.fms.vo.SelectUserVo;
import com.dxs.fms.vo.UpdateDepartmentVo;
import com.dxs.fms.vo.UpdateUserVo;

import org.springframework.stereotype.Service;

/**
 * @author dxs
 * @date 2020/3/16 0016 10:41
 */
@Service
public interface DepartmentService {

    Result1<Integer> add(AddDepartmentVo addDepartmentVo);

    Result1<Integer> updateDelByRealName(String realName);

    Result1<Integer> updateInfo(UpdateDepartmentVo updateDepartmentVo);

    PageUtils<DepartmentDto> getPageByPageAndLimit(Integer page, Integer limit);

    Result1<DepartmentDto> get(SelectDepartmentVo selectDepartmentVo);
}

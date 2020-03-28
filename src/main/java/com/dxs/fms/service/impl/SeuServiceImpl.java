package com.dxs.fms.service.impl;

import com.dxs.fms.dto.AddSeuDto;
import com.dxs.fms.dto.SelectCompanyDto;
import com.dxs.fms.dto.SelectDepartmentDto;
import com.dxs.fms.dto.SelectEmployeeDto;
import com.dxs.fms.dto.SelectPositionDto;
import com.dxs.fms.dto.SeuDto;
import com.dxs.fms.mapper.CompanyMapper;
import com.dxs.fms.mapper.DepartmentMapper;
import com.dxs.fms.mapper.EmployeeMapper;
import com.dxs.fms.mapper.PositionMapper;
import com.dxs.fms.mapper.SeuMapper;
import com.dxs.fms.service.SeuService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddSeuVo;
import com.dxs.fms.vo.SelectSeoVo;
import com.dxs.fms.vo.UpdateSeoVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dxs
 * @date 2020/3/16 0016 14:02
 */
@Service
public class SeuServiceImpl implements SeuService {
    @Autowired
    private SeuMapper seuMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Result1<Integer> add(AddSeuVo addSeuVo) {
        if(addSeuVo == null){
            return new Result1<Integer>(false,-1,new Error("请求失败，请检查有关的数据是否正确"));
        }
        AddSeuDto addSeuDto = new AddSeuDto();
        SelectCompanyDto selectCompanyDto = companyMapper.getCompanyId(addSeuVo.getCompanyName());
        addSeuDto.setCompanyId(selectCompanyDto.getCompanyId());
        SelectPositionDto selectPositionDto = positionMapper.getPositionId(selectCompanyDto.getCompanyId(), addSeuVo.getPositionName());
        addSeuDto.setPositionId(selectPositionDto.getPositionId());
        SelectEmployeeDto selectEmployeeDto = employeeMapper.getEmployeeId(selectCompanyDto.getCompanyId(), addSeuVo.getEmpName());
        addSeuDto.setEmployeeId(selectEmployeeDto.getEmployeeId());
        SelectDepartmentDto selectDepartmentDto = departmentMapper.getDepartmentId(selectCompanyDto.getCompanyId(), addSeuVo.getDeptName());
        addSeuDto.setDepartmentId(selectDepartmentDto.getDeptId());
        addSeuDto.setCreatorId(addSeuVo.getCreatorId());
        addSeuDto.setDel(0);

        Integer  result = seuMapper.addSeu(addSeuDto);
        return new Result1<Integer>(true,result);
    }

    @Override
    public Result1<Integer> updateDelByRealName(String realName) {
        if(realName == null){
            return new Result1<>(false,-1);
        }
        return new Result1<>(true,seuMapper.updateDelByRealName(realName));
    }

    @Override
    public Result1<Integer> updateInfo(UpdateSeoVo updateSeoVo) {
        //if(updateSeoVo == null || updateSeoVo.getEmpRealName() == null) return new Result1<>(false, -1);
        return new Result1<>(true, seuMapper.updateInfo(updateSeoVo));
    }

    @Override
    public PageUtils<SeuDto> getPageByPageAndLimit(Integer page, Integer limit) {
        if(page == null || limit == null) {
            page = 1;
            limit = 5;
        }
        Integer start = PageUtils.calculateStart(page, limit);
        Integer end = PageUtils.calculateEnd(page, limit);
        List<SeuDto> seuDtoList = seuMapper.getPageByPageAndLimit(start, end);
        Integer total = seuMapper.getAll();
        PageUtils<SeuDto> pageUtils = new PageUtils<>();
        pageUtils.setTotal(total);
        pageUtils.setDate(seuDtoList);
        return pageUtils;
    }

    @Override
    public Result1<SeuDto> get(SelectSeoVo selectSeoVo) {
        if(selectSeoVo == null) return new Result1<>(false, new SeuDto());
        return new Result1<>(true, seuMapper.getSeu(selectSeoVo));
    }
}

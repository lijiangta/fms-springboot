package com.dxs.fms.service.impl;

import com.dxs.fms.dto.AddEmployeeDto;
import com.dxs.fms.dto.AddSeuDto;
import com.dxs.fms.dto.AddUserDto;
import com.dxs.fms.dto.DepartmentDto;
import com.dxs.fms.dto.EmployeeDto;
import com.dxs.fms.dto.SelectCompanyDto;
import com.dxs.fms.dto.SelectDepartmentDto;
import com.dxs.fms.dto.SelectEmployeeDto;
import com.dxs.fms.dto.SelectPositionDto;
import com.dxs.fms.mapper.CompanyMapper;
import com.dxs.fms.mapper.DepartmentMapper;
import com.dxs.fms.mapper.EmployeeMapper;
import com.dxs.fms.mapper.PositionMapper;
import com.dxs.fms.mapper.SeuMapper;
import com.dxs.fms.mapper.UserMapper;
import com.dxs.fms.service.EmployeeService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddDepartmentVo;
import com.dxs.fms.vo.AddEmployeeVo;
import com.dxs.fms.vo.RegisterEmployeeVo;
import com.dxs.fms.vo.SelectDepartmentVo;
import com.dxs.fms.vo.SelectEmployeeVo;
import com.dxs.fms.vo.UpdateDepartmentVo;
import com.dxs.fms.vo.UpdateEmployeeVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dxs
 * @date 2020/3/16 0016 14:01
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private SeuMapper seuMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result1<Integer> add(AddEmployeeVo addEmployeeVo) {
        if(addEmployeeVo == null){
            throw  new RuntimeException();
        }
        AddEmployeeDto addEmployeeDto = new AddEmployeeDto();
        addEmployeeDto.setEmployeeRealName(addEmployeeVo.getRealName());
        addEmployeeDto.setEmployeeNickname(addEmployeeVo.getNickname());
        SelectCompanyDto selectCompanyDto = companyMapper.getCompanyId(addEmployeeVo.getCompanyName());
        addEmployeeDto.setCompanyId(selectCompanyDto.getCompanyId());
        addEmployeeDto.setEmployeePositionName(addEmployeeVo.getPositionName());
        if("女".equals(addEmployeeVo.getGender())){
            addEmployeeDto.setGender(0);
        }else if("男".equals(addEmployeeVo.getGender())){
            addEmployeeDto.setGender(1);
        }
        addEmployeeDto.setCreatorId(addEmployeeVo.getCreatorId());

       if(addEmployeeDto.getGender() != null){
           addEmployeeDto.setGender(0);
       }
        addEmployeeDto.setDel(0);

        Integer result = employeeMapper.addEmployee(addEmployeeDto);
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

    @Override
    public Result1<Integer> registerEmployee(RegisterEmployeeVo registerEmployeeVo) {
        if(registerEmployeeVo == null){
            throw  new RuntimeException();
        }
        //添加employee
        AddEmployeeDto addEmployeeDto = new AddEmployeeDto();
        addEmployeeDto.setEmployeeRealName(registerEmployeeVo.getRealName());
        addEmployeeDto.setEmployeeNickname(registerEmployeeVo.getNickname());
        SelectCompanyDto selectCompanyDto = companyMapper.getCompanyId(registerEmployeeVo.getCompanyName());
        addEmployeeDto.setCompanyId(selectCompanyDto.getCompanyId());
        addEmployeeDto.setEmployeePositionName(registerEmployeeVo.getPositionName());
        if("女".equals(registerEmployeeVo.getGender())){
            addEmployeeDto.setGender(0);
        }else if("男".equals(registerEmployeeVo.getGender())){
            addEmployeeDto.setGender(1);
        }
        addEmployeeDto.setCreatorId(registerEmployeeVo.getCreatorId());

        if(addEmployeeDto.getGender() != null){
            addEmployeeDto.setGender(0);
        }
        addEmployeeDto.setDel(0);

        Integer result = employeeMapper.addEmployee(addEmployeeDto);

        //添加seu
        AddSeuDto addSeuDto = new AddSeuDto();
        addSeuDto.setCompanyId(selectCompanyDto.getCompanyId());
        SelectPositionDto selectPositionDto = positionMapper.getPositionId(selectCompanyDto.getCompanyId(), registerEmployeeVo.getPositionName());
        addSeuDto.setPositionId(selectPositionDto.getPositionId());
        SelectEmployeeDto selectEmployeeDto = employeeMapper.getEmployeeId(selectCompanyDto.getCompanyId(), registerEmployeeVo.getEmpName());
        addSeuDto.setEmployeeId(selectEmployeeDto.getEmployeeId());
        SelectDepartmentDto selectDepartmentDto = departmentMapper.getDepartmentId(selectCompanyDto.getCompanyId(), registerEmployeeVo.getDeptName());
        addSeuDto.setDepartmentId(selectDepartmentDto.getDeptId());
        addSeuDto.setCreatorId(registerEmployeeVo.getCreatorId());
        addSeuDto.setDel(0);

        Integer  result1 = seuMapper.addSeu(addSeuDto);

        //添加user
        AddUserDto addUserDto = new AddUserDto();
        addUserDto.setCompanyId(selectCompanyDto.getCompanyId());
        addUserDto.setDeptId(selectDepartmentDto.getDeptId());
        addUserDto.setUserRealName(registerEmployeeVo.getRealName());
        addUserDto.setUserNickname(registerEmployeeVo.getNickname());
        if("女".equals(registerEmployeeVo.getGender())){
            addUserDto.setGender(0);
        }else if("男".equals(registerEmployeeVo.getGender())){
            addUserDto.setGender(1);
        }
        addUserDto.setDel(false);
        Integer  result2 = userMapper.addrUser(addUserDto);

        if(result <= 0 || result1 <= 0 || result2 <= 0){
            return new Result1<Integer>(false,-1,new Error("请求失败，请检查有关的数据是否正确"));
        }
        return new Result1<Integer>(true,result);
    }
}

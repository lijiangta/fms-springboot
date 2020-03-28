package com.dxs.fms.controller.employess;

import com.dxs.fms.dto.AddEmployeeDto;
import com.dxs.fms.dto.DepartmentDto;
import com.dxs.fms.dto.EmployeeDto;
import com.dxs.fms.dto.SelectCompanyDto;
import com.dxs.fms.mapper.CompanyMapper;
import com.dxs.fms.service.DepartmentService;
import com.dxs.fms.service.EmployeeService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.ResponseBody;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddDepartmentVo;
import com.dxs.fms.vo.AddEmployeeVo;
import com.dxs.fms.vo.RegisterEmployeeVo;
import com.dxs.fms.vo.SelectDepartmentVo;
import com.dxs.fms.vo.SelectEmployeeVo;
import com.dxs.fms.vo.UpdateDepartmentVo;
import com.dxs.fms.vo.UpdateEmployeeVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dxs
 * @date 2020/3/16 0016 12:00
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CompanyMapper companyMapper;
    /**
     * 员工注册
     * @param addEmployeeVo 前端传后台的用户对象
     * @return 返回处理结果
     */
    @ExceptionHandler(RuntimeException.class)
    @RequestMapping(method = RequestMethod.GET, value = "/addEmployee")
    public ResponseBody<Result1<Integer>> add(AddEmployeeVo addEmployeeVo){
        Result1<Integer> result = employeeService.add(addEmployeeVo);
        if(result.getData() == -1){
            return new ResponseBody<>("403",result.getError(),"请求失败，请检查有关的数据是否正确");
        }
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 部门注销
     * @param realName 部门真实名称
     * @return 返回对应结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/logout/{realName}")
    public ResponseBody<Result1<Integer>> logout(@PathVariable("realName") String realName){
        Result1<Integer> result = employeeService.updateDelByRealName(realName);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 基于修改的部门信息更新用户
     * @param updateEmployeeVo 需修改的部门信息对象
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/modifyUserInfo")
    public ResponseBody<Result1<Integer>> modifyUserInfo(@RequestBody UpdateEmployeeVo updateEmployeeVo){
        //SelectUserVo selectUserVo = new SelectUserVo();
        Result1<Integer> result = employeeService.updateInfo(updateEmployeeVo);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 分页获取
     * @param page 当前页
     * @param limit 每页限制
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseBody<PageUtils<EmployeeDto>> list(Integer page, Integer limit){
        //SelectUserVo selectUserVo = new SelectUserVo();
        PageUtils<EmployeeDto> result = employeeService.getPageByPageAndLimit(page, limit);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 查询单个部门
     * @param selectEmployeeVo 查询条件对象
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public ResponseBody<Result1<EmployeeDto>> get(@RequestBody SelectEmployeeVo selectEmployeeVo){
        //SelectUserVo selectUserVo = new SelectUserVo();
        Result1<EmployeeDto> result = employeeService.get(selectEmployeeVo);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 员工注册
     * @param registerEmployeeVo 前端传后台的用户对象
     * @return 返回处理结果
     */
    @ExceptionHandler(RuntimeException.class)
    @RequestMapping(method = RequestMethod.POST, value = "/registerEmployee")
    public ResponseBody<Result1<Integer>> registerEmployee(@RequestBody RegisterEmployeeVo registerEmployeeVo){
        Result1<Integer> result = employeeService.registerEmployee(registerEmployeeVo);
        if(result.getData() == -1){
            return new ResponseBody<>("403",result.getError(),"请求失败，请检查有关的数据是否正确");
        }
        return new ResponseBody<>("200", "成功", result);
    }
}

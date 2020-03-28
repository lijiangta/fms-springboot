package com.dxs.fms.controller.department;

import com.dxs.fms.dto.AddCompanyDto;
import com.dxs.fms.dto.AddDepartmentDto;
import com.dxs.fms.dto.DepartmentDto;
import com.dxs.fms.dto.SelectCompanyDto;
import com.dxs.fms.dto.UserDto;
import com.dxs.fms.mapper.CompanyMapper;
import com.dxs.fms.service.DepartmentService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.ResponseBody;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddCompanyVo;
import com.dxs.fms.vo.AddDepartmentVo;
import com.dxs.fms.vo.AddUserVo;
import com.dxs.fms.vo.SelectDepartmentVo;
import com.dxs.fms.vo.SelectUserVo;
import com.dxs.fms.vo.UpdateDepartmentVo;
import com.dxs.fms.vo.UpdateUserVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dxs
 * @date 2020/3/16 0016 10:37
 */
@RestController
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CompanyMapper companyMapper;
    /**
     * 部门注册
     * @param addDepartmentVo 前端传后台的用户对象
     * @return 返回处理结果
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/addDepartment")
    public ResponseBody<Result1<Integer>> addCompany(@RequestBody AddDepartmentVo addDepartmentVo){
        AddDepartmentDto addDepartmentDto = new AddDepartmentDto();
        addDepartmentDto.setDeptName(addDepartmentVo.getDeptNickname());
        addDepartmentDto.setDeptCode(addDepartmentVo.getDeptCode());
        addDepartmentDto.setDeptNickname(addDepartmentVo.getDeptNickname());
        addDepartmentDto.setDeptManagerId(addDepartmentVo.getDeptManagerId());
        addDepartmentDto.setCreatorId(addDepartmentVo.getCreatorId());
        SelectCompanyDto selectCompanyDto = companyMapper.getCompanyId(addDepartmentVo.getCompanyName());
        addDepartmentDto.setCompanyId(selectCompanyDto.getCompanyId());

        Result1<Integer> result = departmentService.add(addDepartmentDto);
        if(result.getData() == -1){
            return new ResponseBody<>("403",result.getError(),"请求失败，请检查有关的数据是否正确");
        }
        return new ResponseBody<>("200","成功",result);
    }

    /**
     * 部门注销
     * @param realName 部门真实名称
     * @return 返回对应结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/logout/{realName}")
    public ResponseBody<Result1<Integer>> logout(@PathVariable("realName") String realName){
        Result1<Integer> result = departmentService.updateDelByRealName(realName);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 基于修改的部门信息更新用户
     * @param updateDepartmentVo 需修改的部门信息对象
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/modifyUserInfo")
    public ResponseBody<Result1<Integer>> modifyUserInfo(@RequestBody UpdateDepartmentVo updateDepartmentVo){
        //SelectUserVo selectUserVo = new SelectUserVo();
        Result1<Integer> result = departmentService.updateInfo(updateDepartmentVo);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 分页获取
     * @param page 当前页
     * @param limit 每页限制
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseBody<PageUtils<DepartmentDto>> list(Integer page, Integer limit){
        //SelectUserVo selectUserVo = new SelectUserVo();
        PageUtils<DepartmentDto> result = departmentService.getPageByPageAndLimit(page, limit);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 查询单个部门
     * @param selectDepartmentVo 查询条件对象
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public ResponseBody<Result1<DepartmentDto>> get(@RequestBody SelectDepartmentVo selectDepartmentVo){
        //SelectUserVo selectUserVo = new SelectUserVo();
        Result1<DepartmentDto> result = departmentService.get(selectDepartmentVo);
        return new ResponseBody<>("200", "成功", result);
    }
}

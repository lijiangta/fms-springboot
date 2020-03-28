package com.dxs.fms.controller.position;

import com.dxs.fms.dto.AddDepartmentDto;
import com.dxs.fms.dto.AddPositionDto;
import com.dxs.fms.dto.PositionDto;
import com.dxs.fms.dto.SelectCompanyDto;
import com.dxs.fms.mapper.CompanyMapper;
import com.dxs.fms.service.PositionService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.ResponseBody;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddDepartmentVo;
import com.dxs.fms.vo.AddPositionVo;
import com.dxs.fms.vo.SelectPositionVo;
import com.dxs.fms.vo.UpdatePositionVo;

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
 * @date 2020/3/16 0016 11:59
 */
@RestController
@RequestMapping("position")
public class PositionController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private CompanyMapper companyMapper;
    /**
     * 部门注册
     * @param addPositionVo 前端传后台的用户对象
     * @return 返回处理结果
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/addPosition")
    public ResponseBody<Result1<Integer>> addPosition(@RequestBody AddPositionVo addPositionVo){
        AddPositionDto addPositionDto = new AddPositionDto();
        addPositionDto.setPositionRealName(addPositionVo.getPositionName());
        addPositionDto.setPositionNickname(addPositionVo.getPositionNickname());
        addPositionDto.setPositionCode(addPositionVo.getPositionCode());
        SelectCompanyDto selectCompanyDto = companyMapper.getCompanyId(addPositionVo.getCompanyName());
        addPositionDto.setCompanyId(selectCompanyDto.getCompanyId());

        Result1<Integer> result = positionService.add(addPositionDto);
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
        Result1<Integer> result = positionService.updateDelByRealName(realName);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 基于修改的部门信息更新用户
     * @param updatePositionVo 需修改的部门信息对象
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/modifyUserInfo")
    public ResponseBody<Result1<Integer>> modifyUserInfo(@RequestBody UpdatePositionVo updatePositionVo){
        //SelectUserVo selectUserVo = new SelectUserVo();
        Result1<Integer> result = positionService.updateInfo(updatePositionVo);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 分页获取
     * @param page 当前页
     * @param limit 每页限制
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseBody<PageUtils<PositionDto>> list(Integer page, Integer limit){
        //SelectUserVo selectUserVo = new SelectUserVo();
        PageUtils<PositionDto> result = positionService.getPageByPageAndLimit(page, limit);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 查询单个部门
     * @param selectPositionVo 查询条件对象
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public ResponseBody<Result1<PositionDto>> get(@RequestBody SelectPositionVo selectPositionVo){
        //SelectUserVo selectUserVo = new SelectUserVo();
        Result1<PositionDto> result = positionService.get(selectPositionVo);
        return new ResponseBody<>("200", "成功", result);
    }
}

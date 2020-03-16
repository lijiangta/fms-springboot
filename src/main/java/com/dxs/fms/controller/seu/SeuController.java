package com.dxs.fms.controller.seu;

import com.dxs.fms.dto.FileDto;
import com.dxs.fms.dto.SeuDto;
import com.dxs.fms.service.FileService;
import com.dxs.fms.service.SeuService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.ResponseBody;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddFileVo;
import com.dxs.fms.vo.AddSeoVo;
import com.dxs.fms.vo.SelectFileVo;
import com.dxs.fms.vo.SelectSeoVo;
import com.dxs.fms.vo.UpdateFileVo;
import com.dxs.fms.vo.UpdateSeoVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dxs
 * @date 2020/3/16 0016 12:01
 */
@RestController
@RequestMapping("seu")
public class SeuController {
    @Autowired
    private SeuService seuService;
    /**
     * 部门注册
     * @param addSeoVo 前端传后台的用户对象
     * @return 返回处理结果
     */
    @ExceptionHandler(RuntimeException.class)
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public ResponseBody<Result1<Integer>> add(AddSeoVo addSeoVo){
        if(addSeoVo == null){
            throw  new RuntimeException();
        }
        Result1<Integer> result = seuService.add(addSeoVo);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 部门注销
     * @param realName 部门真实名称
     * @return 返回对应结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/logout/{realName}")
    public ResponseBody<Result1<Integer>> logout(@PathVariable("realName") String realName){
        Result1<Integer> result = seuService.updateDelByRealName(realName);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 基于修改的部门信息更新用户
     * @param updateSeoVo 需修改的部门信息对象
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/modifyUserInfo")
    public ResponseBody<Result1<Integer>> modifyUserInfo(@RequestBody UpdateSeoVo updateSeoVo){
        //SelectUserVo selectUserVo = new SelectUserVo();
        Result1<Integer> result = seuService.updateInfo(updateSeoVo);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 分页获取
     * @param page 当前页
     * @param limit 每页限制
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseBody<PageUtils<SeuDto>> list(Integer page, Integer limit){
        //SelectUserVo selectUserVo = new SelectUserVo();
        PageUtils<SeuDto> result = seuService.getPageByPageAndLimit(page, limit);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 查询单个部门
     * @param selectSeoVo 查询条件对象
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public ResponseBody<Result1<SeuDto>> get(@RequestBody SelectSeoVo selectSeoVo){
        //SelectUserVo selectUserVo = new SelectUserVo();
        Result1<SeuDto> result = seuService.get(selectSeoVo);
        return new ResponseBody<>("200", "成功", result);
    }
}

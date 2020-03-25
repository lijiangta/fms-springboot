package com.dxs.fms.controller.file;

import com.dxs.fms.dto.EmployeeDto;
import com.dxs.fms.dto.FileDto;
import com.dxs.fms.service.EmployeeService;
import com.dxs.fms.service.FileService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.ResponseBody;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddEmployeeVo;
import com.dxs.fms.vo.AddFileVo;
import com.dxs.fms.vo.SelectEmployeeVo;
import com.dxs.fms.vo.SelectFileVo;
import com.dxs.fms.vo.UpdateEmployeeVo;
import com.dxs.fms.vo.UpdateFileVo;
import com.sun.org.apache.regexp.internal.RE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dxs
 * @date 2020/3/16 0016 12:00
 */
@RestController
@RequestMapping("file")
public class FileController {
    @Autowired
    private FileService fileService;
    /**
     * 部门注册
     * @param addFileVo 前端传后台的用户对象
     * @return 返回处理结果
     */
    @ExceptionHandler(RuntimeException.class)
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public ResponseBody<Result1<Integer>> add(AddFileVo addFileVo){
        if(addFileVo == null){
            throw  new RuntimeException();
        }
        Result1<Integer> result = fileService.add(addFileVo);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 部门注销
     * @param realName 部门真实名称
     * @return 返回对应结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/logout/{realName}")
    public ResponseBody<Result1<Integer>> logout(@PathVariable("realName") String realName){
        Result1<Integer> result = fileService.updateDelByRealName(realName);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 基于修改的部门信息更新用户
     * @param updateFileVo 需修改的部门信息对象
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/modifyUserInfo")
    public ResponseBody<Result1<Integer>> modifyUserInfo(@RequestBody UpdateFileVo updateFileVo){
        //SelectUserVo selectUserVo = new SelectUserVo();
        Result1<Integer> result = fileService.updateInfo(updateFileVo);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 分页获取
     * @param page 当前页
     * @param limit 每页限制
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseBody<PageUtils<FileDto>> list(Integer page, Integer limit){
        //SelectUserVo selectUserVo = new SelectUserVo();
        PageUtils<FileDto> result = fileService.getPageByPageAndLimit(page, limit);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 查询单个部门
     * @param selectFileVo 查询条件对象
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public ResponseBody<Result1<FileDto>> get(@RequestBody SelectFileVo selectFileVo){
        //SelectUserVo selectUserVo = new SelectUserVo();
        Result1<FileDto> result = fileService.get(selectFileVo);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 基于真实姓名查询有关的文件信息
     * @param realName 拥有该文件的人的真实姓名
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/listFile/{realName}")
    public ResponseBody<Result1<FileDto>> listFile(@PathVariable("realName") String realName){
        Result1<FileDto> result = fileService.listFileByUserRealName(realName);
        return new ResponseBody<>("200", "成功", result);
    }
}

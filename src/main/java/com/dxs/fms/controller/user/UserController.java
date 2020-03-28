package com.dxs.fms.controller.user;

import com.dxs.fms.dto.AddSeuDto;
import com.dxs.fms.dto.AddUserDto;
import com.dxs.fms.dto.SelectCompanyDto;
import com.dxs.fms.dto.SelectDepartmentDto;
import com.dxs.fms.dto.UserDto;
import com.dxs.fms.mapper.CompanyMapper;
import com.dxs.fms.mapper.DepartmentMapper;
import com.dxs.fms.mapper.UserMapper;
import com.dxs.fms.service.UserService;
import com.dxs.fms.util.PageUtils;
import com.dxs.fms.util.ResponseBody;
import com.dxs.fms.util.Result1;
import com.dxs.fms.vo.AddUserVo;
import com.dxs.fms.vo.LoginUserVo;
import com.dxs.fms.vo.SelectUserVo;
import com.dxs.fms.vo.UpdateUserVo;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

/**
 * @author dxs
 * @date 2020/3/8 0008 20:51
 */
@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/hello/{username}/{password}")
    public Map<String, String> hello(@PathVariable("username") String username,@PathVariable("password") String password){
        Map<String, String> map = new HashMap<String, String>(1);
        map.put("content","hello");
        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addUser1")
    public String addUser1(AddUserVo addUserVo){
        addUserVo.setUserPassword("wqwq");
        addUserVo.setGender("男");
        addUserVo.setUserRealName("2wqwq");
        addUserVo.setUserNickname("45wqwq4eqweq5");
        if(addUserVo == null){
            throw  new RuntimeException();
        }
        //Result1<Integer> result = userService.addUser(addUserVo);
        return "success";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public ResponseBody<Result1<UserDto>> loginUser(@RequestBody SelectUserVo selectUserVo){
        //SelectUserVo selectUserVo = new SelectUserVo();
        selectUserVo.setUserRealName(selectUserVo.getUserRealName());
        selectUserVo.setPassword(selectUserVo.getPassword());
        Result1<UserDto> result = userService.getUser(selectUserVo);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 用户注册
     * @param addUserVo 前端传后台的用户对象
     * @return 返回处理结果
     */
    @ExceptionHandler(RuntimeException.class)
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public ResponseBody<Result1<Integer>> add(@RequestBody AddUserVo addUserVo){
        Result1<Integer> result = userService.addUser(addUserVo);
        if(result.getData() == -1){
            return new ResponseBody<>("403",result.getError(),"请求失败，请检查有关的数据是否正确");
        }
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 用户密码
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/login/{username}/{password}")
    public ResponseBody<Result1<UserDto>> login(@PathVariable("username") String username, @PathVariable("password") String password){
        SelectUserVo selectUserVo = new SelectUserVo();
        selectUserVo.setUserRealName(username);
        selectUserVo.setPassword(password);
        Result1<UserDto> result = userService.getUser(selectUserVo);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 用户登录
     * @param loginUserVo 登录对象
     * @return 返回结果
     */
    @CrossOrigin
    @PostMapping(value = "/login")
    public ResponseBody<Result1<LoginUserVo>> userLogin(@RequestBody LoginUserVo loginUserVo){
        SelectUserVo selectUserVo = new SelectUserVo();
        selectUserVo.setUserRealName(loginUserVo.getUsername());
        selectUserVo.setPassword(loginUserVo.getPassword());
        Result1<UserDto> result = userService.getUser(selectUserVo);
        if(result.getError() != null){
            return new ResponseBody<>("403", result.getError(), "用户名不存在");
        }
        //将对象传给前端
        LoginUserVo loginUserVo1 = new LoginUserVo();
        loginUserVo1.setUsername(result.getData().getUserRealName());
        loginUserVo1.setPassword(result.getData().getUserPassword());
        Result1<LoginUserVo> result1 = new Result1<>();
        result1.setData(loginUserVo1);
        return new ResponseBody<>("200", "成功", result1);
    }

    /**
     * 用户注销
     * @param realName 真实姓名
     * @return 返回对应结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/logout/{realName}")
    public ResponseBody<Result1<Integer>> userLogout(@PathVariable("realName") String realName){
        //SelectUserVo selectUserVo = new SelectUserVo();
        Result1<Integer> result = userService.updateDelByRealName(realName);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 分页获取
     * @param page 当前页
     * @param limit 每页限制
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseBody<PageUtils<UserDto>> userList(Integer page,Integer limit){
        //SelectUserVo selectUserVo = new SelectUserVo();
        PageUtils<UserDto> result = userService.getUserByPageAndLimit(page, limit);
        return new ResponseBody<>("200", "成功", result);
    }

    /**
     * 基于修改的用户信息更新用户
     * @param updateUserVo 需修改的用户信息对象
     * @return 返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/modifyUserInfo")
    public ResponseBody<Result1<Integer>> userList(@RequestBody UpdateUserVo updateUserVo){
        //SelectUserVo selectUserVo = new SelectUserVo();
        Result1<Integer> result = userService.updateUserInfo(updateUserVo);
        return new ResponseBody<>("200", "成功", result);
    }
}

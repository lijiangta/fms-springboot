package com.dxs.fms.controller.user;

import com.dxs.fms.pojo.UserPojo;
import com.dxs.fms.service.UserService;
import com.dxs.fms.util.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

import javax.servlet.http.HttpSession;

/**
 * @author dxs
 * @date 2020/2/27 0027 23:11
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody UserPojo requestUser, HttpSession session) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        System.out.println(requestUser.getUsername()+requestUser.getPassword());
        //if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
        UserPojo user = userService.get(username, requestUser.getPassword());
        if (user == null){
            String message = "账号密码错误";
            System.out.println(message);
            return new Result(400);
        } else {
            //session用于保持用户的登录状态，但是移动端该方法不可行
            session.setAttribute("user", user);
            return new Result(200);
        }
    }
}

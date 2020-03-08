package com.dxs.fms.controller.user;

import com.dxs.fms.pojo.UserPojo;
import com.dxs.fms.util.Result;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

/**
 * @author dxs
 * @date 2020/2/28 0028 23:40
 */
@Controller
public class Login1Controller {
    @CrossOrigin
    @PostMapping(value = "api1/login1")
    @ResponseBody
    public Result login(@RequestBody UserPojo requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        System.out.println(requestUser.getUsername()+requestUser.getPassword());
        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
            String message = "账号密码错误";
            System.out.println(message);
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}

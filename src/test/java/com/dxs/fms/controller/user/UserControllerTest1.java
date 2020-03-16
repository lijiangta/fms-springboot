package com.dxs.fms.controller.user;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author dxs
 * @date 2020/3/13 0013 13:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest1 {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        //让每个测试用例启动之前都构建这样一个启动项
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void greatUserWhithDetailView() throws Exception{
        String content = "{\"userName\":\"二十岁以后\",\"passWord\":null,\"id\":88}";

        //MockMvcRequestBuilders构建GET请求
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                //请求编码和数据格式为json和UTF8
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                //请求的参数，为json的格式
                .content(content))
                //期望的返回值 或者返回状态码
                .andExpect(MockMvcResultMatchers.status().is5xxServerError())
                //返回请求的字符串信息
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

}
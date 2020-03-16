package com.dxs.fms.controller.user;



import com.dxs.fms.vo.SelectUserVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath*:"+"**web-config.xml")
@WebAppConfiguration
public class MockMvcTest {
    private static Logger logger = LoggerFactory.getLogger(MockMvcTest.class);
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        logger.info("before");
    }

    @Test
    public void demo() throws Exception {
        mockMvc.perform(get("/user/hello").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("{content:hello}"));
    }

    @Test
    public void demo1() throws Exception {
        String var = "loginName";
        String var2 = "loginName";
        String var3 = "loginName";

        mockMvc.perform(
                get("/user/hello/"+ var +"/" +var2)
                        .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))
                        .param("username",var)
                        .param("password",var2)
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("{content:hello}"));
    }

    @Test
    public void userLogin() throws Exception{
        SelectUserVo selectUserVo = new SelectUserVo();
        selectUserVo.setPassword("123456");
        selectUserVo.setUserRealName("admin");
        selectUserVo.setUserRealName("admin");
        //设置值
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        java.lang.String requestJson = ow.writeValueAsString(selectUserVo);
        //{"statusCode":"200","message":"成功","data":{"success":true,"data":{"userRealName":"admin","userNickname":"admin"},"error":null}}
        String params = "{'userRealName':'admin', userNickname:'admin', 'password':'123456'}";
        MvcResult result = mockMvc.perform(post("/user/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
                        .accept(MediaType.APPLICATION_JSON))
                        .andReturn();
                //.andExpect(jsonPath("$.data.data.userRealName").value("admin")) //验证id是否为1，jsonPath的使用
                //.andExpect(jsonPath("$.data.data.userNickname").value("admin")); // 验证name是否等于Zhukeqian
        MockHttpServletResponse response = result.getResponse();
        String resultContent = response.getContentAsString();
        logger.info("@@"+resultContent);
    }
}
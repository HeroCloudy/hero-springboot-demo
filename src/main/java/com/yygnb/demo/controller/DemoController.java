package com.yygnb.demo.controller;

import com.yygnb.demo.common.exception.CommonException;
import com.yygnb.demo.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: com.yygnb.demo.controller.DemoController
 * @Description: <h1></h1>
 * @Date: 2022/7/26 00:28
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/7/26 00:28   dscloudy    Create File.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("demo")
public class DemoController {

    private final DemoService demoService;

    @GetMapping("hello")
    public String hello(String msg) {
        String result = "Hello Spring Boot ! " + msg;
        if ("demo".equals(msg)) {
            throw new CommonException("发生错误----这是自定义异常");
        }
        return result;
    }

    @GetMapping("async")
    public void asyncDemo(String msg) {
        demoService.send(msg);
    }
}

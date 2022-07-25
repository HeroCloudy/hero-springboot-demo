package com.yygnb.demo.controller;

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
@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("hello")
    public String hello(String msg) {
        String result = "Hello Spring Boot ! " + msg;
        System.out.println(result);
        return result;
    }
}

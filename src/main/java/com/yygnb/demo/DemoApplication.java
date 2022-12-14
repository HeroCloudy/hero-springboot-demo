package com.yygnb.demo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Title: com.yygnb.demo.DemoApplication
 * @Description: <h1></h1>
 * @Date: 2022/7/26 00:25
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/7/26 00:25   dscloudy    Create File.
 */
@EnableAdminServer
@EnableAsync
@MapperScan("com.yygnb.demo.mapper")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

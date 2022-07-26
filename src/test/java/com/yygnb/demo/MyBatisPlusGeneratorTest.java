package com.yygnb.demo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

import java.util.Collections;

/**
 * @Title: com.yygnb.demo.MyBatisPlusGeneratorTest.com.yygnb.demo.MyBatisPlusGeneratorTest
 * @Description: <h1></h1>
 * @Date: 2022/7/26 14:09
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/7/26 14:09   dscloudy    Create File.
 */
public class MyBatisPlusGeneratorTest {

    @Test
    public void testGenerate() {
        String url = "jdbc:mysql://localhost:3306/hero_springboot_demo?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "Mysql.123";
        String author = "hero-yyg";
        String outputDir = "/Users/liuyun/DSCloudy2022/hero/temp-code";
        String parentPackage = "com.yygnb.demo";
        String moduleName = null;
        String outputFileXml = "/Users/liuyun/DSCloudy2022/hero/temp-code/xml";

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
                            .outputDir(outputDir); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(parentPackage) // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, outputFileXml)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("computer"); // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}

package com.yygnb.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Title: com.yygnb.demo.config.DocInfo
 * @Description: <h1></h1>
 * @Date: 2022/7/29 14:56
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/7/29 14:56   dscloudy    Create File.
 */
@Data
@Component
@ConfigurationProperties(prefix = "doc-info")
public class DocInfo {

    private String title = "Demo Title";
    private String description = "Demo Description";
    private String version = "v0.0.1";
    private String websiteName = "Demo Website";
    private String websiteUrl = "http://www.yygnb.com";
}

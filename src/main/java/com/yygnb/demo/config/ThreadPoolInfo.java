package com.yygnb.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Title: com.yygnb.demo.config.ThreadPoolInfo
 * @Description: <h1></h1>
 * @Date: 2022/9/5 18:12
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/9/5 18:12   dscloudy    Create File.
 */
@Data
@Component
@ConfigurationProperties(prefix = "thread-pool")
public class ThreadPoolInfo {

    private int corePoolSize = 1;

    private int maxPoolSize = Integer.MAX_VALUE;

    private int keepAliveSeconds = 60;

    private int queueCapacity = Integer.MAX_VALUE;

    private String threadNamePrefix = "thread-";
}

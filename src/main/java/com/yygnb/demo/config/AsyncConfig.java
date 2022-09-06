package com.yygnb.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Title: com.yygnb.demo.config.AsyncConfig
 * @Description: <h1></h1>
 * @Date: 2022/9/5 18:10
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/9/5 18:10   dscloudy    Create File.
 */
@RequiredArgsConstructor
@Configuration
public class AsyncConfig {

    private final ThreadPoolInfo info;

    @Bean("asyncExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(info.getCorePoolSize());
        executor.setMaxPoolSize(info.getMaxPoolSize());
        executor.setQueueCapacity(info.getQueueCapacity());
        executor.setThreadNamePrefix(info.getThreadNamePrefix());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}

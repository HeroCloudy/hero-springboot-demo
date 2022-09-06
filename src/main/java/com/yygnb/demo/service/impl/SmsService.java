package com.yygnb.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Title: com.yygnb.demo.service.impl.SmsService
 * @Description: <h1></h1>
 * @Date: 2022/9/5 17:34
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/9/5 17:34   dscloudy    Create File.
 */
@Slf4j
@Service
public class SmsService {

    @Async
    public void sendSms(String msg) {
        log.info("开始发送短信: {}", msg);
        int i = new Random().nextInt(5);
        try {
            Thread.sleep(i * 1000);
            log.info("短信发送成功");
        } catch (InterruptedException e) {
            log.error("短信发送失败");
            e.printStackTrace();
        }
    }
}

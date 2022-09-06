package com.yygnb.demo.service.impl;

import com.yygnb.demo.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Title: com.yygnb.demo.service.impl.DemoServiceImpl
 * @Description: <h1></h1>
 * @Date: 2022/9/5 17:39
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/9/5 17:39   dscloudy    Create File.
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class DemoServiceImpl implements DemoService {

    private final EmailService emailService;
    private final SmsService smsService;

    @Override
    public void send(String msg) {
        log.info("发别发送短信和邮件");
        smsService.sendSms(msg);
        emailService.sendEmail(msg);
        log.info("Demo Service 结束");
    }
}

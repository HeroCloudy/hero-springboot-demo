package com.yygnb.demo;

import org.junit.Test;

import static com.alibaba.druid.filter.config.ConfigTools.encrypt;
import static com.alibaba.druid.filter.config.ConfigTools.genKeyPair;

public class ConfigToolsTest {

    @Test
    public void testPassword() throws Exception {
        String password = "Mysql.123";
        String[] arr = genKeyPair(512);
        System.out.println("privateKey:" + arr[0]);
        System.out.println("publicKey:" + arr[1]);
        System.out.println("password:" + encrypt(arr[0], password));
    }
}

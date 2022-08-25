package com.yygnb.demo.crypto;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @Title: com.yygnb.demo.crypto.ByteTest
 * @Description: <h1></h1>
 * @Date: 2022/8/15 00:29
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/8/15 00:29   dscloudy    Create File.
 */
public class ByteTest {

    @Test
    public void testStrBytes() {
        String str = "a";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        for (byte b : bytes) {
            System.out.println(b);
            System.out.println(Integer.toBinaryString(b));
        }
    }

    @Test
    public void testStrBytes2() {
        String str = "ab=";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        for (byte b : bytes) {
            System.out.println(b);
            System.out.println(Integer.toBinaryString(b));
        }
    }
}

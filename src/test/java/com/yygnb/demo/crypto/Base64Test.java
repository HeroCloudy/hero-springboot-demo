package com.yygnb.demo.crypto;

import org.junit.Test;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Title: com.yygnb.demo.crypto.Base64Test
 * @Description: <h1></h1>
 * @Date: 2022/8/15 02:00
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/8/15 02:00   dscloudy    Create File.
 */
public class Base64Test {

    /**
     * JDK Base64 编码
     */
    @Test
    public void testEncode() {
        String result = Base64.getEncoder().encodeToString("ab".getBytes(StandardCharsets.UTF_8));
        System.out.println(result); // YWI=
    }

    /**
     * JDK Base64 解码
     */
    @Test
    public void testDecode() {
        byte[] decode = Base64.getDecoder().decode("YWI=");
        String plainText = new String(decode);
        System.out.println(plainText); // ab
    }

    /**
     * springframework Base64 编码
     */
    @Test
    public void testUtilsEncode() {
        String result = Base64Utils.encodeToString("ab".getBytes(StandardCharsets.UTF_8));
        System.out.println(result); // YWI=
    }

    /**
     * springframework Base64 解码
     */
    @Test
    public void testUtilsDecode() {
        byte[] bytes = Base64Utils.decodeFromString("YWI=");
        System.out.println(new String(bytes)); // ab
    }
}

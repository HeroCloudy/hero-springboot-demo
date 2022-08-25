package com.yygnb.demo.crypto;

import org.junit.Test;
import org.springframework.security.crypto.codec.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MessageDigestTest {

    private String md(String input, String algorithm) throws Exception {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
        return new String(Hex.encode(digest));
    }

    @Test
    public void testMessageDigest() throws Exception {
        String input = "Hello，张三";
        System.out.println(md(input, "MD5"));
        System.out.println(md(input, "SHA-1"));
        System.out.println(md(input, "SHA-256"));
        System.out.println(md(input, "SHA-512"));
    }
}

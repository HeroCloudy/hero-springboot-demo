package com.yygnb.demo.utils;

/**
 * @Title: com.yygnb.demo.utils.HexUtils
 * @Description: <h1></h1>
 * @Date: 2022/8/25 09:57
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/8/25 09:57   dscloudy    Create File.
 */
public class HexUtils {

    /**
     * 十六进制字符串转 byte[]
     */
    public static byte[] toBytes(String hex) {
        if (hex == null || hex.length() < 1) {
            return null;
        } else {
            byte[] result = new byte[hex.length() / 2];
            int j = 0;
            for (int i = 0; i < hex.length(); i += 2) {
                result[j++] = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
            }
            return result;
        }
    }

    /**
     * byte[] 转十六进制字符串
     */
    public static String toHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        for (byte b : bytes) {
            int v = b & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}

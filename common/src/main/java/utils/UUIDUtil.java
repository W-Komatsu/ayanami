package utils;

import java.util.Random;
import java.util.UUID;

/**
 * UUID工具类
 *
 * @author wangxiaosong
 * @date 2020/3/26
 */
public class UUIDUtil {
    /**
     * 获取32位UUID
     *
     * @return UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成随机验证码
     */
    public static String getVerificationCode(int length) {
        String baseNumber = "0123456789";
        Random random = new Random();
        char[] nonceChars = new char[length];

        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = baseNumber.charAt(random.nextInt(baseNumber.length()));
        }
        return String.valueOf(nonceChars);
    }
}

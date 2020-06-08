package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期相关工具函数
 *
 * @author wangxiaosong
 * @date 2020/3/26
 */
public class DateUtil {
    public static final String FMT_sdf17 = "yyyyMMddHHmmssSSS";
    public static final String FMT_sdf14 = "yyyyMMddHHmmss";
    public static final String FMT_sdf12 = "yyyyMMddHHmm";
    public static final String FMT_sdf14_L = "yyyy-MM-dd HH:mm:ss";
    public static final String FMT_sdf8 = "yyyyMMdd";
    public static final String FMT_sdf8_L = "yyyy-MM-dd";
    public static final String FMT_sdf6 = "yyMMdd";

    /**
     * 格式化日期对象
     * @param date 日期对象
     * @param format 格式
     * @return 格式化字符串
     */
    public static String formatDate(LocalDateTime date, String format) {
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * 转换日期
     * @param date 日期字符串
     * @param format 日期字符串格式
     * @return 日期对象
     */
    public static LocalDateTime parseDate(String date, String format) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
    }
}

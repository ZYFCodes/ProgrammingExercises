package org.zyf.programming.dynamicprogrammingexercises;

import com.google.common.collect.Lists;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 描述：求两个字符串的最长公共子串，如“abcdefg”和“adefgwgeweg”的最长公共子串为“defg”（子串必须是连续的）
 *
 * @author yanfengzhang
 * @date 2020-04-30 17:02
 */
public class MaxSubString {

    /**
     * 功能描述：两个字符串的最长公共子串
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return List<String> 最长公共子串
     * @author yanfengzhang
     * @date 2020-04-30 17:11
     */
    public static List<String> getMaxSubString(String str1, String str2) {
        if (StringUtils.isEmpty(str1) || StringUtils.isEmpty(str2)) {
            return null;
        }

        String max;
        String min;
        if (str1.length() > str2.length()) {
            max = str1;
            min = str2;
        } else {
            max = str2;
            min = str1;
        }

        List<String> subStrings = Lists.newArrayList();
        String maxSubString = "";
        for (int i = 0; i < min.length(); i++) {
            for (int begin = 0, end = min.length() - i; begin < end; begin++) {
                String tmp = min.substring(begin, end);
                if (max.contains(tmp) && tmp.length() >= maxSubString.length()) {
                    maxSubString = tmp;
                    subStrings.add(maxSubString);
                }
            }
        }
        return subStrings;
    }

    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "adefgwgeweg";
        System.out.println("当前存在两个字符串分别为：abcdefg，adefgwgeweg");
        System.out.println("两个字符串的最长公共子串为：" + getMaxSubString(str1, str2));
    }
}

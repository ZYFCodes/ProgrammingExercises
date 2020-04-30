package org.zyf.programming.stringexercises;

/**
 * 描述：字符串全排列
 *
 * @author yanfengzhang
 * @date 2020-04-30 15:46
 */
public class AllArrangeString {
    public static void main(String[] args) {
        String str = "abc";
        allArrange(str.toCharArray(), 0);

    }

    public static void allArrange(char[] chars, int n) {
        if (n == chars.length - 1) {
            System.out.println(String.valueOf(chars));
        }
        for (int i = n; i < chars.length; i++) {
            char tmp = chars[i];
            chars[i] = chars[n];
            chars[n] = tmp;
            allArrange(chars, n + 1);
        }
    }
}

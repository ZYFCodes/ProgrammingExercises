package org.zyf.programming.stringexercises;

/**
 * 描述：字符串转数字
 *
 * @author yanfengzhang
 * @date 2020-04-30 16:30
 */
public class StrToInt {
    public static int strToInt(String str) {
        if (null == str || str.isEmpty()) {
            return 0;
        }
        int result = 0;
        char[] strArray = str.toCharArray();
        char base = '0';
        for (int i = strArray.length; i > 0; i--) {
            result += (strArray[strArray.length - i] - base) * Math.pow(10, i - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.print(strToInt(str));
    }

}

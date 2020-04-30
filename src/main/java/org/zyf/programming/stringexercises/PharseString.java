package org.zyf.programming.stringexercises;

import java.util.Stack;

/**
 * 描述：回文字符串相关练习
 *
 * @author yanfengzhang
 * @date 2020-04-30 14:15
 */
public class PharseString {

    /**
     * 功能描述：给定一个字符串，问是否能通过添加一个字母将其变为回文串。
     *
     * @param str 具体字符串
     * @return boolean 是否能通过添加一个字母将其变为回文串
     * @author yanfengzhang
     * @date 2020-04-30 14:24
     */
    public boolean isPharseStringWithChar(String str) {
        if (null == str) {
            return false;
        }
        if (str.length() == 1 || str.length() == 2) {
            return true;
        }
        for (int i = 1; i < str.length() >> 1; i++) {
            if (str.toCharArray()[i] != str.toCharArray()[str.length() - i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * 功能描述：给定一个字符串，问是否为回文串。
     *
     * @param str 具体字符串
     * @return boolean 是否回文串
     * @author yanfengzhang
     * @date 2020-04-30 15:22
     */
    public boolean isPharseString(String str) {
        if (null == str) {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }

        Stack<Character> stack = new Stack<Character>();
        char[] strArray = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            stack.push(strArray[i]);
        }
        for (int i = 0; i < str.length(); i++) {
            if (stack.pop() != strArray[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PharseString pharseString = new PharseString();
        String str1 = "coco";
        String str2 = "4h3211123h4";

        System.out.println("当前字符串：" + str1 + " 通过添加一个字母将其变为回文串的可能为：" + pharseString.isPharseStringWithChar(str1));
        System.out.println("当前字符串：" + str2 + " 通过添加一个字母将其变为回文串的可能为：" + pharseString.isPharseString(str2));
    }
}

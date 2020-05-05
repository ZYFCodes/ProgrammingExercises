package org.zyf.programming.greedyalgorithm;

/**
 * 描述：给出一个整数，从该整数中去掉K个数字，要求剩下的数字形成的新整数尽可能的小。
 *
 * @author yanfengzhang
 * @date 2020-05-05 13:45
 */
public class GetMinRemoveKDigits {

    /**
     * 功能描述：去掉K个数字，获得删除后的最小值
     *
     * @author yanfengzhang
     * @date 2020-05-05 14:04
     */
    public static String getMinRemoveKDigits(String num, int k) {
        /*新整数的最终长度=原整数长度-k*/
        int newLength = num.length() - k;
        /*创建一个栈，用于接收所有的数字*/
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            /*遍历当前数字*/
            char c = num.charAt(i);
            /*当栈顶元素遍历到的当前数字时，栈顶数字出栈，相当于删除数字*/
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top--;
                k--;
            }
            /*遍历到当前数字入栈*/
            stack[top++] = c;
        }
        /**/
        int offset = 0;
        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }
        return offset == newLength ? "0" : new String(stack, offset, newLength - offset);
    }

    public static void main(String[] args) {
        System.out.println("给出一个整数1593212，从该整数中去掉3个数字，要求剩下的数字形成的新整数尽可能的小");
        System.out.println("这个数为：" + getMinRemoveKDigits("1593212", 3));
    }
}

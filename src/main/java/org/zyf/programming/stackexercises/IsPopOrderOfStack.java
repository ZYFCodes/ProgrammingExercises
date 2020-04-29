package org.zyf.programming.stackexercises;

import java.util.Stack;

/**
 * 描述：判断栈的压入对应弹出序列是否正确
 *
 * @author yanfengzhang
 * @date 2020-04-29 18:35
 */
public class IsPopOrderOfStack {

    /**
     * 功能描述：判断栈的压入对应弹出序列是否正确
     *
     * @param pushArray 入栈顺序
     * @param popArray  出栈顺序
     * @return boolean 判断栈的压入对应弹出序列是否正确
     * @author yanfengzhang
     * @date 2020-04-29 18:55
     */
    public static boolean isPopOrderOfStack(int[] pushArray, int[] popArray) {
        if (pushArray == null || popArray == null) {
            return false;
        }

        Stack<Integer> stack = new Stack<Integer>();
        /*用于标识弹出序列的位置*/
        int popIndex = 0;
        for (int i = 0; i < pushArray.length; i++) {
            stack.push(pushArray[i]);
            while (!stack.isEmpty() && stack.peek() == popArray[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushArray = {1, 2, 3, 4, 5};
        int[] popArray1 = {4, 5, 3, 2, 1};
        int[] popArray2 = {4, 3, 5, 1, 2};

        System.out.println("当前入栈顺序为12345，出栈顺序为45321，栈的压入对应弹出序列是否正确：" + isPopOrderOfStack(pushArray, popArray1));
        System.out.println("当前入栈顺序为12345，出栈顺序为43512，栈的压入对应弹出序列是否正确：" + isPopOrderOfStack(pushArray, popArray2));
    }
}

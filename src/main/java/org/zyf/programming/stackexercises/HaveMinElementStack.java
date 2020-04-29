package org.zyf.programming.stackexercises;

import java.util.Stack;

/**
 * 描述：包含min函数的栈
 * 栈最小元素的min函数这个功能，言外之意要求我们对当前栈弹出的应该是当前栈内的最小元素
 *
 * @author yanfengzhang
 * @date 2020-04-29 17:25
 */
public class HaveMinElementStack {
    Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    /**
     * 功能描述：栈的入栈操作
     *
     * @param element 入栈元素
     * @author yanfengzhang
     * @date 2020-04-29 17:30
     */
    public void push(Integer element) {
        dataStack.push(element);
        if (minStack.isEmpty()) {
            minStack.push(element);
        } else if (element < minStack.peek()) {
            minStack.push(element);
        }
    }

    /**
     * 功能描述：栈的出栈操作
     *
     * @return Integer 出栈元素
     * @author yanfengzhang
     * @date 2020-04-29 17:33
     */
    public Integer pop() {
        if (dataStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return dataStack.pop();
    }

    /**
     * 功能描述：栈的最小元素
     *
     * @return Integer 栈最小元素
     * @author yanfengzhang
     * @date 2020-04-29 17:35
     */
    public Integer min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        HaveMinElementStack haveMinElementStack = new HaveMinElementStack();

        System.out.println("进行入栈操作，入栈元素依次为：2，4，7，5, 1, 4, 5, 7, 9, 0, 5");
        haveMinElementStack.push(2);
        haveMinElementStack.push(4);
        haveMinElementStack.push(7);
        haveMinElementStack.push(5);
        haveMinElementStack.push(1);
        haveMinElementStack.push(4);
        haveMinElementStack.push(5);
        haveMinElementStack.push(7);
        haveMinElementStack.push(9);
        haveMinElementStack.push(0);
        haveMinElementStack.push(5);

        System.out.println("当前栈中最小元素为：" + haveMinElementStack.min());
        System.out.println("进行出栈操作，出栈元素为：" + haveMinElementStack.pop());
        System.out.println("再次进行入栈操作，入栈元素为：7");
        haveMinElementStack.push(7);
        System.out.println("再次进行出栈操作，出栈元素为：" + haveMinElementStack.pop());
        System.out.println("当前栈中最小元素为：" + haveMinElementStack.min());
        System.out.println("再次进行出栈操作，出栈元素为：" + haveMinElementStack.pop());
        System.out.println("当前栈中最小元素为：" + haveMinElementStack.min());
        System.out.println("再次进行出栈操作，出栈元素为：" + haveMinElementStack.pop());
        System.out.println("当前栈中最小元素为：" + haveMinElementStack.min());
        System.out.println("再次进行出栈操作，出栈元素为：" + haveMinElementStack.pop());
        System.out.println("当前栈中最小元素为：" + haveMinElementStack.min());
        System.out.println("再次进行出栈操作，出栈元素为：" + haveMinElementStack.pop());
        System.out.println("当前栈中最小元素为：" + haveMinElementStack.min());
        System.out.println("再次进行出栈操作，出栈元素为：" + haveMinElementStack.pop());
        System.out.println("当前栈中最小元素为：" + haveMinElementStack.min());
        System.out.println("再次进行出栈操作，出栈元素为：" + haveMinElementStack.pop());
        System.out.println("当前栈中最小元素为：" + haveMinElementStack.min());
        System.out.println("再次进行出栈操作，出栈元素为：" + haveMinElementStack.pop());
        System.out.println("当前栈中最小元素为：" + haveMinElementStack.min());

    }
}

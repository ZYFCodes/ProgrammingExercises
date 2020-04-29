package org.zyf.programming.stackexercises;

import java.util.Stack;

/**
 * 描述：两个栈实现一个队列
 *
 * @author yanfengzhang
 * @date 2020-04-29 16:25
 */
public class TwoStackImplQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 功能描述：队列入队操作
     *
     * @param element 入队元数据
     * @author yanfengzhang
     * @date 2020-04-29 16:30
     */
    public void offer(Integer element) {
        stack1.push(element);
    }

    /**
     * 功能描述：队列出队操作
     *
     * @return Integer 返回 当前对头元素
     * @throws
     * @author yanfengzhang
     * @date 2020-04-29 16:37
     */
    public Integer poll() throws Exception {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new Exception("Queue is empty!");
        }

        return stack2.pop();
    }

    public static void main(String[] args) throws Exception {
        TwoStackImplQueue twoStackImplQueue = new TwoStackImplQueue();

        System.out.println("进行入队操作，入队元素依次为：1，3，5，4，2");
        twoStackImplQueue.offer(1);
        twoStackImplQueue.offer(3);
        twoStackImplQueue.offer(5);
        twoStackImplQueue.offer(4);
        twoStackImplQueue.offer(2);

        System.out.println("进行出队队操作，入队元素为：" + twoStackImplQueue.poll());
        System.out.println("再次进行入队操作，入队元素为：7");
        twoStackImplQueue.offer(7);
        System.out.println("再次进行出队队操作，入队元素为：" + twoStackImplQueue.poll());
    }

}

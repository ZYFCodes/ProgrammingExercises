package org.zyf.programming.queueexercises;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 描述：两个队列实现一个栈
 *
 * @author yanfengzhang
 * @date 2020-04-29 16:48
 */
public class TwoQueueImplStack {
    Queue<Integer> queue1 = new ArrayDeque<Integer>();
    Queue<Integer> queue2 = new ArrayDeque<Integer>();

    /**
     * 功能描述：栈的入栈操作
     *
     * @param element 入栈元素
     * @author yanfengzhang
     * @date 2020-04-29 16:58
     */
    public void push(Integer element) {
        /*两个队列都为空时，优先考虑 queue1*/
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.offer(element);
            return;
        }

        /*如果queue1为空，queue2有数据，直接放入queue2*/
        if (queue1.isEmpty()) {
            queue2.offer(element);
            return;
        }

        /*如果queue2为空，queue1有数据，直接放入queue1中*/
        if (queue2.isEmpty()) {
            queue1.offer(element);
        }

    }

    /**
     * 功能描述：栈的出栈操作
     *
     * @return Integer 栈顶元素
     * @throws Exception 栈为空
     * @author yanfengzhang
     * @date 2020-04-29 17:06
     */
    public Integer pop() throws Exception {
        /*如果两个栈都为空，则没有元素可以弹出，异常*/
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new Exception("Stack is empty!");
        }

        /*如果queue1中没有元素，queue2中有元素，将其queue2中的元素依次放入queue1中，直到最后一个元素，弹出即可*/
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }

        /*如果queue2中没有元素，queue1中有元素，将其queue1中的元素依次放入queue2中，直到最后一个元素，弹出即可*/
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        return (Integer)null;
    }

    public static void main(String[] args) throws Exception {

        TwoQueueImplStack twoQueueImplStack = new TwoQueueImplStack();

        System.out.println("进行入栈操作，入栈元素依次为：2，4，7，5");
        twoQueueImplStack.push(2);
        twoQueueImplStack.push(4);
        twoQueueImplStack.push(7);
        twoQueueImplStack.push(5);

        System.out.println("进行出栈操作，出栈元素为：" + twoQueueImplStack.pop());
        System.out.println("再次进行入栈操作，入栈元素为：1");
        twoQueueImplStack.push(1);
        System.out.println("再次进行出栈操作，出栈元素为：" + twoQueueImplStack.pop());
    }
}

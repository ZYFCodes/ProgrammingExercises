package org.zyf.programming.listexercises;

/**
 * 描述：关于双向链表相关的问题
 *
 * @author yanfengzhang
 * @date 2020-05-10 16:01
 */
public class SortDoubleLinkedList {

    /**
     * 功能描述：向一个升序双向链表中插入一个元素，依旧满足升序
     *
     * @param head  升序双向链表
     * @param value 插入的值
     * @return 插入新值后的升序双向链表
     * @throws
     * @author yanfengzhang
     * @date 2020-05-10 23:47
     */
    public static DoubleListNode insertListNode(DoubleListNode head, int value) {
        if (head == null) {
            return null;
        }

        DoubleListNode dummy = new DoubleListNode(value);
        dummy.next = head;

        DoubleListNode temp = new DoubleListNode(value);
        if (head.value >= value) {
            temp.next = head;
            return temp;
        }
        while (head != null && head.next != null) {
            if (head.value <= value && value < head.next.value) {
                temp.next = head.next;
                head.next = temp;
                temp.pre = head;
                head.next.pre = temp;
                break;
            }
            head = head.next;
        }
        while (head != null && head.next != null) {
            head = head.next;
        }
        if (head.value <= value) {
            head.next = temp;
        }

        return dummy.next;
    }

    /**
     * 功能描述：打印当前链表
     *
     * @param head 当前链表
     * @return String 返回链表信息
     * @author yanfengzhang
     * @date 2020-04-29 23:09
     */
    public static String printListNode(DoubleListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.value);
            head = head.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DoubleListNode doubleListNode1 = new DoubleListNode(1);
        DoubleListNode doubleListNode2 = new DoubleListNode(2);
        DoubleListNode doubleListNode3 = new DoubleListNode(4);
        DoubleListNode doubleListNode4 = new DoubleListNode(5);
        DoubleListNode doubleListNode5 = new DoubleListNode(6);
        doubleListNode1.next = doubleListNode2;
        doubleListNode2.pre = doubleListNode1;
        doubleListNode2.next = doubleListNode3;
        doubleListNode3.pre = doubleListNode2;
        doubleListNode3.next = doubleListNode4;
        doubleListNode4.pre = doubleListNode3;
        doubleListNode4.next = doubleListNode5;
        doubleListNode5.pre = doubleListNode4;
        doubleListNode5.next = null;

        System.out.println("原始双列表信息为：" + printListNode(doubleListNode1));
        DoubleListNode doubleListNode = insertListNode(doubleListNode1, 3);
        System.out.println("插入某个数值后的双列表信息为：" + printListNode(doubleListNode));
    }
}

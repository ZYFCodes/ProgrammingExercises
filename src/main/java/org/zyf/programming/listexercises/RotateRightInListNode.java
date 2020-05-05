package org.zyf.programming.listexercises;

/**
 * 描述：将给定的链表向右转动k个位置，k是非负数。
 * 例如：给定1->2->3->4->5->null ， k=2， 返回4->5->1->2->3->null。
 *
 * @author yanfengzhang
 * @date 2020-05-05 22:54
 */
public class RotateRightInListNode {

    /**
     * 功能描述：分析可看出，要得到结果，其实就是修改几个节点间链接关系，具体包括以下三点：
     * 1.末尾节点指向头结点，2.倒数第n个元素为头结点，3.倒数第n+1个元素指向null
     *
     * @author yanfengzhang
     * @date 2020-05-05 23:37
     */
    public ListNode rotateRight(ListNode head, int n) {
        /*若链表为空，则直接返回null*/
        if (head == null || n < 0) {
            return null;
        }

        /*若n为0，则直接返回链表本身*/
        if (n == 0) {
            return head;
        }

        /*用来计数：传入的链表的节点个数*/
        int count = 1;
        ListNode p = head;
        /*直到 p 找到链表末尾节点，停止循环*/
        while (p.next != null) {
            p = p.next;
            count++;
        }
        /*末尾节点指向头结点，整个链表成为一个环*/
        p.next = head;

        if (n > count) {
            n = n % count;
        }

        /*通过循环让p指向倒数第n+1个元素*/
        for (int i = 0; i < count - n; i++) {
            p = p.next;
        }
        /*倒数第n个元素为头结点*/
        head = p.next;
        /*倒数第n+1个元素为末尾节点，指向null*/
        p.next = null;
        return head;
    }

    /**
     * 功能描述：打印当前链表
     *
     * @param head 当前链表
     * @return String 返回链表信息
     * @author yanfengzhang
     * @date 2020-04-29 23:09
     */
    public String printListNode(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.value);
            head = head.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        RotateRightInListNode rotateRightInListNode = new RotateRightInListNode();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;

        System.out.println("当前链表情况为：" + rotateRightInListNode.printListNode(listNode1));
        ListNode newListnode = rotateRightInListNode.rotateRight(listNode1, 3);
        System.out.println("当前链表向右移动3位情况为：" + rotateRightInListNode.printListNode(newListnode));
    }
}

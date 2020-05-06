package org.zyf.programming.listexercises;

/**
 * 描述：将给定的单链表L： L 0→L 1→…→L n-1→L n, 重新排序为： L 0→L n →L 1→L n-1→L 2→L n-2→…
 * 要求使用原地算法，并且不改变节点的值
 * 例如：对于给定的单链表{1,2,3,4}，将其重新排序为{1,4,2,3}.
 *
 * @author yanfengzhang
 * @date 2020-05-06 23:38
 */
public class ReorderListNode {

    /**
     * 功能描述：重新排序链表
     * 解题思路:①找到中间节点;②将链表拆分并逆序后半部分;③重新间隔拼接在一起
     *
     * @param head 当前链表
     * @author yanfengzhang
     * @date 2020-05-06 23:40
     */
    public void reorderList(ListNode head) {
        /*链表长度小于2时直接返回*/
        if (head == null || head.next == null) {
            return;
        }
        /*设置两个快慢指针*/
        ListNode slow = head;
        ListNode fast = head;
        /*fast走两步同时slow只走一步，从而找到中间节点*/
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        /*将链表从slow处拆开*/
        ListNode after = slow.next;
        slow.next = null;

        /*将后半部分链表逆序*/
        ListNode pre = null;
        while (after != null) {
            ListNode temp = after.next;
            after.next = pre;
            pre = after;
            after = temp;
        }

        /*将pre链表间隔插入head链表*/
        ListNode first = head;
        ListNode second = pre;
        while (first != null && second != null) {
            ListNode firstTemp = first.next;
            ListNode secondTemp = second.next;
            first.next = second;
            first = firstTemp;
            second.next = first;
            second = secondTemp;
        }
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
            stringBuilder.append(head.value).append(" ");
            head = head.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        ReorderListNode reorderListNode = new ReorderListNode();
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

        System.out.println("当前链表情况为：" + reorderListNode.printListNode(listNode1));
        reorderListNode.reorderList(listNode1);
        System.out.println("当前链表新排序情况为：" + reorderListNode.printListNode(listNode1));
    }
}

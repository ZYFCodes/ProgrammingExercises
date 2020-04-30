package org.zyf.programming.listexercises;

/**
 * 描述：输入两个链表（单链表），找出它们的第一个公共结点。
 *
 * @author yanfengzhang
 * @date 2020-04-30 09:35
 */
public class CommonNodeInListNode {

    /**
     * 功能描述：找出两个链表（单链表）第一个公共结点
     *
     * @param pHead1 当前链表1
     * @param pHead2 当前链表2
     * @return ListNode 第一个公共结点
     * @author yanfengzhang
     * @date 2020-04-30 11:12
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int length1 = getLengthOfListNode(pHead1);
        int length2 = getLengthOfListNode(pHead2);

        int different = 0;
        if (length1 >= length2) {
            different = length1 - length2;
            while (different != 0) {
                pHead1 = pHead1.next;
                different--;
            }
        } else {
            different = length2 - length1;
            while (different != 0) {
                pHead2 = pHead2.next;
                different--;
            }
        }

        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }


    /**
     * 功能描述：获取链表长度
     *
     * @param head 当前链表
     * @return int 链表长度
     * @author yanfengzhang
     * @date 2020-04-30 11:11
     */
    public int getLengthOfListNode(ListNode head) {
        int length = 0;
        if (head == null) {
            return length;
        }

        while (head.next != null) {
            head = head.next;
            length++;
        }
        return length + 1;
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
        CommonNodeInListNode commonNodeInListNode = new CommonNodeInListNode();

        /*链表1*/
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

        /*链表2*/
        ListNode listNode11 = new ListNode(6);
        ListNode listNode21 = new ListNode(0);
        ListNode listNode31 = new ListNode(7);
        listNode11.next = listNode21;
        listNode21.next = listNode31;
        listNode31.next = listNode5;

        System.out.println("当前链表1的相关信息为：" + commonNodeInListNode.printListNode(listNode1));
        System.out.println("当前链表2的相关信息为：" + commonNodeInListNode.printListNode(listNode11));
        System.out.println("两个链表的第一个公共节点为：" + commonNodeInListNode.findFirstCommonNode(listNode1, listNode11).value);
    }
}

package org.zyf.programming.listexercises;

/**
 * 描述：链表第K个节点信息
 *
 * @author yanfengzhang
 * @date 2020-04-29 22:47
 */
public class FindKthToTailInListNode {

    /**
     * 功能描述：输入一个链表（单链表），输出该链表中倒数第k个结点。
     *
     * @param head 当前链表
     * @param k    倒数第k个
     * @return ListNode 倒数第k个节点信息
     * @author yanfengzhang
     * @date 2020-04-29 23:15
     */
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode index1 = head;
        ListNode index2 = head;

        while (k != 0) {
            if (index1 != null) {
                index1 = index1.next;
                k--;
            } else {
                return null;
            }
        }

        while (index1 != null) {
            index1 = index1.next;
            index2 = index2.next;
        }
        return index2;
    }

    /**
     * 功能描述：输出该链表中中间结点
     * @author yanfengzhang
     * @date 2020-04-29 23:25
     * @param head 当前链表
     * @return ListNode 输出该链表中中间结点信息
    */
    public ListNode findMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode index1 = head;
        ListNode index2 = head;
        while (index2.next != null) {
            index1 = index1.next;
            index2 = index2.next.next;
        }
        return index1;
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
        FindKthToTailInListNode findKthToTailInListNode = new FindKthToTailInListNode();

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

        System.out.println("当前链表情况为：" + findKthToTailInListNode.printListNode(listNode1));
        System.out.println("当前链表的倒数第4个节点信息为：" + findKthToTailInListNode.findKthToTail(listNode1, 4).value);
        System.out.println("当前链表的中间节点信息为：" + findKthToTailInListNode.findMiddleNode(listNode1).value);
    }
}

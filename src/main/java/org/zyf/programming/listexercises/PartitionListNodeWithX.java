package org.zyf.programming.listexercises;

/**
 * 描述：给出一个链表和一个值x，以x为参照将链表划分成两部分，使所有小于x的节点都位于大于或等于x的节点之前。
 * 要求：两个部分之内的节点之间要保持的原始相对顺序。
 *
 * @author yanfengzhang
 * @date 2020-05-06 19:03
 */
public class PartitionListNodeWithX {

    /**
     * 功能描述：以某个值分割链表
     * 思路：新建两个节点preHead1与preHead2，分别为指向两个链表的头结点。
     * 把节点值小于x的节点链接到链表1上，节点值大等于x的节点链接到链表2上。
     * 最后把两个链表相连即可
     *
     * @param head 当前链表
     * @param x    具体的数值
     * @return 以某个值分割链表重组的链表
     * @author yanfengzhang
     * @date 2020-05-06 23:32
     */
    public ListNode partitionListNodeWithX(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode prehead1 = new ListNode(0);
        ListNode preHead2 = new ListNode(0);
        ListNode cur1 = prehead1, cur2 = preHead2;
        while (head != null) {
            if (head.value < x) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }

        cur1.next = preHead2.next;
        cur2.next = null;
        return prehead1.next;
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

        PartitionListNodeWithX partitionListNodeWithX = new PartitionListNodeWithX();
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(7);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(1);
        ListNode listNode7 = new ListNode(12);
        ListNode listNode8 = new ListNode(3);
        ListNode listNode9 = new ListNode(11);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;

        System.out.println("当前链表情况为：" + partitionListNodeWithX.printListNode(listNode1));
        ListNode newListnode = partitionListNodeWithX.partitionListNodeWithX(listNode1, 5);
        System.out.println("当前链表的中间33到6反转后的链表情况为：" + partitionListNodeWithX.printListNode(newListnode));
    }
}

package org.zyf.programming.listexercises;

/**
 * 描述：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * @author yanfengzhang
 * @date 2020-04-30 11:21
 */
public class MergeTwoSortedLists {

    /**
     * 功能描述：两个有序链表合成后的新有序链表
     *
     * @param l1 当前链表1
     * @param l2 当前链表2
     * @return ListNode 合成后的新有序链表
     * @author yanfengzhang
     * @date 2020-04-30 11:42
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode mergedListNode = head;
        while (l1 != null && l2 != null) {
            if (l1.value > l2.value) {
                mergedListNode.next = l2;
                l2 = l2.next;
            } else {
                mergedListNode.next = l1;
                l1 = l1.next;
            }
            mergedListNode = mergedListNode.next;
        }

        mergedListNode.next = (l1 == null ? l2 : l1);
        return head.next;
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
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

        /*链表1*/
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        /*链表2*/
        ListNode listNode11 = new ListNode(7);
        ListNode listNode21 = new ListNode(8);
        ListNode listNode31 = new ListNode(9);
        listNode11.next = listNode21;
        listNode21.next = listNode31;

        System.out.println("当前链表1的相关信息为：" + mergeTwoSortedLists.printListNode(listNode1));
        System.out.println("当前链表2的相关信息为：" + mergeTwoSortedLists.printListNode(listNode11));
        ListNode mergedListNode = mergeTwoSortedLists.mergeTwoLists(listNode1, listNode11);
        System.out.println("两个链表的第一个公共节点为：" + mergeTwoSortedLists.printListNode(mergedListNode));
    }
}

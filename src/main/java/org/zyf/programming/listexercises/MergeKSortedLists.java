package org.zyf.programming.listexercises;

/**
 * 描述：合并K个有序链表
 *
 * @author yanfengzhang
 * @date 2020-05-11 14:12
 */
public class MergeKSortedLists {

    /**
     * 功能描述：合并K个有序链表
     *
     * @param lists K个有序链表集合
     * @return 合并K个有序链表的结果
     * @author yanfengzhang
     * @date 2020-05-11 14:23
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    /**
     * 功能描述：分治算法依次合并
     * 通过mid将数组一分为二，并不断缩小规模，当规模为1时返回并开始合并
     * 通过合并两个链表，不断增大其规模，整体看就是不断缩小-最后不断扩大的过程
     *
     * @param lists K个有序链表集合
     * @param begin 链表起始位置
     * @param end   链表结束位置
     * @return 合并K个有序链表的结果
     * @author yanfengzhang
     * @date 2020-05-11 14:24
     */
    private ListNode helper(ListNode[] lists, int begin, int end) {
        if (begin == end) {
            return lists[begin];
        }
        int mid = begin + (end - begin) / 2;
        ListNode left = helper(lists, begin, mid);
        ListNode right = helper(lists, mid + 1, end);
        return merge(left, right);
    }

    /**
     * 功能描述：合并两个有序链表
     *
     * @param l1 有序链表1
     * @param l2 有序链表2
     * @return 合并后的有序链表
     * @author yanfengzhang
     * @date 2020-05-11 14:26
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }
        if (l1.value <= l2.value) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
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
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

        /*链表1*/
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        /*链表2*/
        ListNode listNode11 = new ListNode(7);
        ListNode listNode21 = new ListNode(8);
        ListNode listNode31 = new ListNode(9);
        listNode11.next = listNode21;
        listNode21.next = listNode31;

        /*链表3*/
        ListNode listNode12 = new ListNode(2);
        ListNode listNode22 = new ListNode(4);
        ListNode listNode32 = new ListNode(7);
        ListNode listNode42 = new ListNode(10);
        ListNode listNode52 = new ListNode(12);
        listNode12.next = listNode22;
        listNode22.next = listNode32;
        listNode32.next = listNode42;
        listNode42.next = listNode52;

        /*链表4*/
        ListNode listNode13 = new ListNode(7);
        ListNode listNode23 = new ListNode(8);
        ListNode listNode33 = new ListNode(9);
        listNode13.next = listNode23;
        listNode23.next = listNode33;

        /*链表5*/
        ListNode listNode14 = new ListNode(6);
        ListNode listNode24 = new ListNode(13);
        ListNode listNode34 = new ListNode(14);
        listNode14.next = listNode24;
        listNode24.next = listNode34;

        ListNode[] lists = {listNode1, listNode11, listNode12, listNode13, listNode14};

        System.out.println("当前链表1的相关信息为：" + mergeKSortedLists.printListNode(listNode1));
        System.out.println("当前链表2的相关信息为：" + mergeKSortedLists.printListNode(listNode11));
        System.out.println("当前链表3的相关信息为：" + mergeKSortedLists.printListNode(listNode12));
        System.out.println("当前链表4的相关信息为：" + mergeKSortedLists.printListNode(listNode13));
        System.out.println("当前链表5的相关信息为：" + mergeKSortedLists.printListNode(listNode14));
        ListNode mergedKListNode = mergeKSortedLists.mergeKLists(lists);
        System.out.println("两个链表合并后的新链表为：" + mergeKSortedLists.printListNode(mergedKListNode));
    }

}

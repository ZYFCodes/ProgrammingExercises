package org.zyf.programming.listexercises;

/**
 * 描述：在O(n log n)的时间内使用常数级空间复杂度对链表进行排序。
 *
 * @author yanfengzhang
 * @date 2020-05-06 18:50
 */
public class SortList {

    /**
     * 功能描述：在O(n log n)的时间内使用常数级空间复杂度对链表进行排序
     * 思路：归并排序
     *
     * @author yanfengzhang
     * @date 2020-05-06 18:51
     */
    public ListNode sortList(ListNode head) {
        /*1.判定是否为空或者只有一个元素，这也是归并排序中归的停止条件*/
        if (head == null || head.next == null) {
            return head;
        }

        /*2.将链表截成两段*/
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        /*3.此时pre跟slow指的一样，现在将链表从中间断开*/
        pre.next = null;

        /*4.继续再对上面分开的链表再分*/
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        /*5.递归分开之后就应该按照一定的规则合并了*/
        return merge(l1, l2);
    }

    /**
     * 功能描述：归并排序的并过程
     *
     * @author yanfengzhang
     * @date 2020-05-06 18:57
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        /*新建一个结点用于串联并过程结果*/
        ListNode head = new ListNode(0);
        ListNode mergedListNode = head;

        /*并的过程，谁小谁就接到p后面*/
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                mergedListNode.next = l1;
                l1 = l1.next;
            } else {
                mergedListNode.next = l2;
                l2 = l2.next;
            }
            mergedListNode = mergedListNode.next;
        }

        /*如果有一段没有结束，直接接到后面即可*/
        if (l1 != null) {
            mergedListNode.next = l1;
        }

        if (l2 != null) {
            mergedListNode.next = l2;
        }

        /*返回下一个结点*/
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
            stringBuilder.append(head.value).append(" ");
            head = head.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        SortList sortList = new SortList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(8);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(21);
        ListNode listNode7 = new ListNode(17);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(19);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;

        System.out.println("当前链表情况为：" + sortList.printListNode(listNode1));
        ListNode newListnode = sortList.sortList(listNode1);
        System.out.println("当前链表排序后的链表情况为：" + sortList.printListNode(newListnode));
    }
}

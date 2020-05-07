package org.zyf.programming.listexercises;

/**
 * 描述：按实际情况删除链表中的重复元素
 *
 * @author yanfengzhang
 * @date 2020-05-07 10:47
 */
public class DeleteDuplicates {

    /**
     * 功能描述：给出一个排好序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
     * 例如：给出的链表为1->2->3->3->4->4->5, 返回1->2->5.
     *
     * @param head 当前链表
     * @return 新链表
     * @author yanfengzhang
     * @date 2020-05-07 10:50
     */
    public ListNode deleteDuplicatesNoSave(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode pre = newHead;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.value != cur.next.value) {
                pre = cur;
            } else {
                while (cur.next != null && cur.value == cur.next.value) {
                    cur = cur.next;
                }
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }

    /**
     * 功能描述：删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
     * 例如：给出的链表为1->1->2,返回1->2.  给出的链表为1->1->2->3->3,返回1->2->3.
     *
     * @param head 当前链表
     * @return 新链表
     * @author yanfengzhang
     * @date 2020-05-07 11:19
     */
    public ListNode deleteDuplicatesAndSave(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode index1 = head, index2 = head;
        while (index1 != null && index2 != null) {
            if (index1.value == index2.value) {
                index1.next = index2.next;
            } else {
                index1 = index1.next;
            }
            index2 = index1.next;
        }
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
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(6);
        ListNode listNode8 = new ListNode(6);
        ListNode listNode9 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;

        ListNode listNode11 = new ListNode(1);
        ListNode listNode21 = new ListNode(2);
        ListNode listNode31 = new ListNode(2);
        ListNode listNode41 = new ListNode(4);
        ListNode listNode51 = new ListNode(4);
        ListNode listNode61 = new ListNode(6);
        ListNode listNode71 = new ListNode(6);
        ListNode listNode81 = new ListNode(6);
        ListNode listNode91 = new ListNode(9);
        listNode11.next = listNode21;
        listNode21.next = listNode31;
        listNode31.next = listNode41;
        listNode41.next = listNode51;
        listNode51.next = listNode61;
        listNode61.next = listNode71;
        listNode71.next = listNode81;
        listNode81.next = listNode91;

        System.out.println("当前链表情况为：" + deleteDuplicates.printListNode(listNode1));
        ListNode newListnode1 = deleteDuplicates.deleteDuplicatesNoSave(listNode1);
        System.out.println("进行操作---》删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素：" + deleteDuplicates.printListNode(newListnode1));
        System.out.println("当前链表情况为：" + deleteDuplicates.printListNode(listNode11));
        ListNode newListnode2 = deleteDuplicates.deleteDuplicatesAndSave(listNode11);
        System.out.println("进行操作---》删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次：" + deleteDuplicates.printListNode(newListnode2));
    }
}

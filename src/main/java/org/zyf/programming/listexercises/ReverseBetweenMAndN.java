package org.zyf.programming.listexercises;

/**
 * 描述：将一个链表m位置到n位置之间的区间反转，要求使用原地算法，并且在一次扫描之内完成反转。
 * 例如：给出的链表为1->2->3->4->5->NULL, m = 2 ，n = 4, 返回1->4->3->2->5->NULL.
 * 注意：给出的m，n满足以下条件：1 ≤ m ≤ n ≤ 链表长度
 *
 * @author yanfengzhang
 * @date 2020-05-05 22:23
 */
public class ReverseBetweenMAndN {

    /**
     * 功能描述：将一个链表m位置到n位置之间的区间反转
     *
     * @param head 当前链表
     * @param m    开始反转下标
     * @param n    结束反转下标
     * @return 反转的链表
     * @author yanfengzhang
     * @date 2020-05-05 22:35
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preStart = dummy;
        ListNode start = head;
        for (int i = 1; i < m; i++) {
            preStart = start;
            start = start.next;
        }

        /*reverse*/
        for (int i = 0; i < n - m; i++) {
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = preStart.next;
            preStart.next = temp;
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
    public String printListNode(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.value);
            head = head.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReverseBetweenMAndN reverseBetweenMAndN = new ReverseBetweenMAndN();

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

        System.out.println("当前链表情况为：" + reverseBetweenMAndN.printListNode(listNode1));
        ListNode newListnode = reverseBetweenMAndN.reverseBetween(listNode1, 3, 6);
        System.out.println("当前链表的中间3到6反转后的链表情况为：" + reverseBetweenMAndN.printListNode(newListnode));
    }
}

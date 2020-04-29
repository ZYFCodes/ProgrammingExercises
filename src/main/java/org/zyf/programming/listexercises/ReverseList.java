package org.zyf.programming.listexercises;

/**
 * 描述：反转链表
 *
 * @author yanfengzhang
 * @date 2020-04-29 19:03
 */
public class ReverseList {

    /**
     * 功能描述：将链表进行反转
     * @author yanfengzhang
     * @date 2020-04-29 22:39
     * @param head 当前链表
     * @return ListNode 反转以后的链表
    */
    public ListNode reverseList(ListNode head) {
        /*head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；*/
        if (null == head) {
            return null;
        }

        /*当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了。所以需要用到pre和next两个节点
        1->2->3->4->5  //1<-2<-3 4->5*/
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            /*做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
            如此就可以做到反转链表的效果
            先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂*/
            next = head.next;
            /*保存完next，就可以让head从指向next变成指向pre了*/
            head.next = pre;
            /*head指向pre后，就继续依次反转下一个节点
            让pre，head，next依次向后移动一个节点，继续下一次的指针反转*/
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 功能描述：打印当前链表
     * @author yanfengzhang
     * @date 2020-04-29 23:09
     * @param head 当前链表
     * @return String 返回链表信息
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
        ReverseList reverseList = new ReverseList();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        System.out.println("原链表为：" + reverseList.printListNode(listNode1));
        System.out.println("反转链表为：" + reverseList.printListNode(reverseList.reverseList(listNode1)));
    }
}

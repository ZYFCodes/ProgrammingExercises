package org.zyf.programming.listexercises;

/**
 * 描述：链表中的环相关练习
 *
 * @author yanfengzhang
 * @date 2020-04-29 23:28
 */
public class CycleInListNode {

    /**
     * 功能描述：判断当前链表是否有环
     *
     * @param head 当前链表
     * @return boolean 判断当前链表是否有环
     * @author yanfengzhang
     * @date 2020-04-29 23:46
     */
    public boolean isCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode index1 = head;
        ListNode index2 = head;
        while (index2.next != null) {
            index1 = index1.next;
            index2 = index2.next.next;
            if (index1 == index2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 功能描述：获得当前链表的环的长度
     *
     * @param head 当前链表
     * @return int 当前链表的环的长度
     * @author yanfengzhang
     * @date 2020-04-29 23:59
     */
    public int lengthOfCycle(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode index1 = head;
        ListNode index2 = head;
        while (index2.next != null) {
            index1 = index1.next;
            index2 = index2.next.next;
            if (index1 == index2) {
                break;
            }
        }

        int lengthOfCycle = 0;
        while (index2.next != null) {
            index1 = index1.next;
            index2 = index2.next.next;
            if (index1 == index2) {
                break;
            }
            lengthOfCycle++;
        }
        return lengthOfCycle + 1;
    }

    /**
     * 功能描述：找到有环链表的入环节点
     *
     * @param head 当前链表
     * @return ListNode 有环链表的入环节点
     * @author yanfengzhang
     * @date 2020-04-30 00:18
     */
    public ListNode findRingNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode index1 = head;
        ListNode index2 = head;
        ListNode firstMeet = null;
        ListNode secondMeet = head;
        while (index2.next != null) {
            index1 = index1.next;
            index2 = index2.next.next;
            if (index1 == index2) {
                firstMeet = index2;
                break;
            }
        }

        while (secondMeet.next != null) {
            firstMeet = firstMeet.next;
            secondMeet = secondMeet.next;
            if (firstMeet == secondMeet) {
                break;
            }
        }
        return secondMeet;
    }


    public static void main(String[] args) {
        CycleInListNode cycleInListNode = new CycleInListNode();

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
        listNode9.next = listNode5;

        System.out.println("当前链表状态为：1-2-3-4-5-6-7-8-9-5，-代表指向下一个节点");
        System.out.println("当前链表是否有环：" + cycleInListNode.isCycle(listNode1));
        System.out.println("当前链表有环，且环的长度为：" + cycleInListNode.lengthOfCycle(listNode1));
        System.out.println("当前链表有环，且入环节点为：" + cycleInListNode.findRingNode(listNode1).value);
    }

}

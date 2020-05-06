package org.zyf.programming.treeexercises;

import java.util.Arrays;

/**
 * 描述：给出一个升序排列的链表或数组，将其转化为平衡二叉搜索树（BST）
 *
 * @author yanfengzhang
 * @date 2020-05-06 16:34
 */
public class SortedNumberToBST {

    /**
     * 功能描述：给出一个升序排序的数组，将其转化为平衡二叉搜索树（BST）
     *
     * @param nums 一个升序排序的数组
     * @return 平衡二叉搜索树（BST）
     * @author yanfengzhang
     * @date 2020-05-06 16:45
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            /*异常判断*/
            return null;
        }

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] num, int low, int high) {
        if (low > high) {
            /*递归的出口*/
            return null;
        }
        int mid = (low + high) >> 1;
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBST(num, low, mid - 1);
        node.right = sortedArrayToBST(num, mid + 1, high);

        return node;
    }

    /**
     * 功能描述：给定一个单链表，其中的元素按升序排序，请将它转化成平衡二叉搜索树（BST）
     *
     * @param head 给定一个单链表，其中的元素按升序排序
     * @author yanfengzhang
     * @date 2020-05-06 16:47
     */
    public TreeNode sortedListToBST(ListNode head) {
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        /*申请两个指针，fast移动速度是low的两倍*/
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);

        return root;
    }

    /**
     * 描述：链表结构
     *
     * @author yanfengzhang
     * @date 2020-04-29 19:00
     */
    public static class ListNode {

        int val;
        ListNode next;

        public ListNode(int value) {
            this.val = value;
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
    public static String printListNode(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SortedNumberToBST sortedNumberToBST = new SortedNumberToBST();
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        System.out.println("当前升序数组为：" + Arrays.toString(array));
        System.out.println("当前升序链表为：" + printListNode(listNode1));
        boolean test = sortedNumberToBST.sortedArrayToBST(array).equals(sortedNumberToBST.sortedListToBST(listNode1));
        System.out.println("其构建的平衡二叉搜索树是一样的：" + test);

    }

}

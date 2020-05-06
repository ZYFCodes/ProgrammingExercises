package org.zyf.programming.treeexercises;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述：给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 * 用递归和迭代两种方法解决这个问题
 *
 * @author yanfengzhang
 * @date 2020-05-06 17:19
 */
public class MirrorTreeNode {

    /**
     * 功能描述：采用递归方式判断这棵树是否是自身的镜像（即：是否对称）
     *
     * @param root 当前树信息
     * @author yanfengzhang
     * @date 2020-05-06 17:35
     */
    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private static boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return check(node1.left, node2.right) && check(node1.right, node2.left);
    }

    /**
     * 功能描述：采用非递归方式判断这棵树是否是自身的镜像（即：是否对称）
     *
     * @param root 当前树信息
     * @author yanfengzhang
     * @date 2020-05-06 17:35
     */
    public static boolean isSymmetricWithQueue(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isMirror = true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root.left == null || root.right == null) {
            return root.left == root.right;
        }
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                size -= 2;

                if ((left == null || right == null) && left != right) {
                    return false;
                }
                if (left == null || right == null) {
                    continue;
                }
                if (left.val != right.val) {
                    return false;
                }

                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
            }
        }

        return isMirror;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(3);

        TreeNode t7 = new TreeNode(5);
        TreeNode t8 = new TreeNode(6);
        TreeNode t9 = new TreeNode(7);
        TreeNode t10 = new TreeNode(8);
        TreeNode t11 = new TreeNode(8);
        TreeNode t12 = new TreeNode(7);
        TreeNode t13 = new TreeNode(6);
        TreeNode t14 = new TreeNode(5);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;

        t3.left = t7;
        t3.right = t8;
        t4.left = t9;
        t4.right = t10;
        t5.left = t11;
        t5.right = t12;
        t6.left = t13;
        t6.right = t14;

        System.out.println("【采用递归方式】当前的这棵树是否是自身的镜像（即：是否对称）：" + isSymmetric(root));
        System.out.println("【采用非递归方式】当前的这棵树是否是自身的镜像（即：是否对称）：" + isSymmetricWithQueue(root));
    }
}

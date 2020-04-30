package org.zyf.programming.treeexercises;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 描述：输入一棵二叉树，判断该二叉树是否是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一颗平衡二叉树。
 *
 * @author yanfengzhang
 * @date 2020-04-30 13:54
 */
public class IsBalancedTree {

    /**
     * 功能描述：判断该二叉树是否是平衡二叉树
     *
     * @param root 当前树信息
     * @return boolean 判断该二叉树是否是平衡二叉树
     * @author yanfengzhang
     * @date 2020-04-30 14:04
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }

        int leftDepth = getTreeDepth(root.left);
        int rightDepyh = getTreeDepth(root.right);
        int difference = leftDepth - rightDepyh;
        if (difference > 1 || difference < -1) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述：求该树的深度
     *
     * @param root 当前树信息
     * @return int 树的深度
     * @author yanfengzhang
     * @date 2020-04-30 13:50
     */
    public int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 功能描述：根据链表构建一颗二叉树
     *
     * @param inputList 输入具体的二叉树信息
     * @return TreeNode 具体的二叉树
     * @author yanfengzhang
     * @date 2020-04-30 12:11
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        TreeNode node = null;
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    public static void main(String[] args) {
        IsBalancedTree isBalancedTree = new IsBalancedTree();
        LinkedList<Integer> inputList = new LinkedList<Integer>(
                Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4)
        );

        TreeNode pRoot = createBinaryTree(inputList);
        System.out.println("当前树:判断该二叉树是否是平衡二叉树：" + isBalancedTree.isBalanced(pRoot));
    }
}

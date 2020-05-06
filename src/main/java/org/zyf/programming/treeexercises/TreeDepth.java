package org.zyf.programming.treeexercises;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 描述：输入一棵二叉树，求该树的深度。
 *
 * @author yanfengzhang
 * @date 2020-04-30 11:49
 */
public class TreeDepth {

    /**
     * 功能描述：求该树的深度
     * @author yanfengzhang
     * @date 2020-04-30 13:50
     * @param pRoot 当前树信息
     * @return int 树的深度
    */
    public int getTreeDepth(TreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }

        int left = getTreeDepth(pRoot.left);
        int right = getTreeDepth(pRoot.right);
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
        TreeDepth treeDepth = new TreeDepth();
        LinkedList<Integer> inputList = new LinkedList<Integer>(
                Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4)
        );

        TreeNode pRoot = createBinaryTree(inputList);
        System.out.println("当前树的深度为：" + treeDepth.getTreeDepth(pRoot));
    }
}

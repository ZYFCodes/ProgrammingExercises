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

    public static void main(String[] args) {
        TreeDepth treeDepth = new TreeDepth();
        LinkedList<Integer> inputList = new LinkedList<Integer>(
                Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4)
        );

        TreeNode pRoot = TreeNode.createBinaryTree(inputList);
        System.out.println("当前树的深度为：" + treeDepth.getTreeDepth(pRoot));
    }

    public int getTreeDepth(TreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }

        int left = getTreeDepth(pRoot.left);
        int right = getTreeDepth(pRoot.right);
        return left > right ? left + 1 : right + 1;
    }
}

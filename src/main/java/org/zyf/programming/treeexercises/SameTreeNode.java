package org.zyf.programming.treeexercises;

/**
 * 描述：给出两个二叉树，请写出一个判断两个二叉树是否相等的函数。
 * 判断两个二叉树相等的条件是：两个二叉树的结构相同，并且相同的节点上具有相同的值。
 *
 * @author yanfengzhang
 * @date 2020-05-06 17:43
 */
public class SameTreeNode {

    /**
     * 功能描述：判断两个二叉树是否相等
     *
     * @author yanfengzhang
     * @date 2020-05-06 17:46
     */
    public boolean isSameTree(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        return treeNode1.val == treeNode2.val &&
                isSameTree(treeNode1.left, treeNode2.left) &&
                isSameTree(treeNode1.right, treeNode2.right);
    }
}

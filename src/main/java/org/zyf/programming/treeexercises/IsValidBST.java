package org.zyf.programming.treeexercises;

import java.util.Stack;

/**
 * 描述：判断给出的二叉树是否是一个二叉搜索树（BST）
 * 二叉搜索树的定义如下
 * 一个节点的左子树上节点的值都小于自身的节点值
 * 一个节点的右子树上节点的值都小于自身的节点值
 * 所有节点的左右子树都必须是二叉搜索树
 *
 * @author yanfengzhang
 * @date 2020-05-06 18:24
 */
public class IsValidBST {

    /**
     * 功能描述：判断给出的二叉树是否是一个二叉搜索树（BST）
     * 利用二叉树的中序遍历
     *
     * @param root 当前树信息
     * @return 判断给出的二叉树是否是一个二叉搜索树（BST）
     * @author yanfengzhang
     * @date 2020-05-06 18:25
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur == null) {
                cur = stack.pop();
                if (pre != null && pre.val >= cur.val) {
                    return false;
                }
                pre = cur;
                cur = cur.right;
            } else {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return true;
    }
}

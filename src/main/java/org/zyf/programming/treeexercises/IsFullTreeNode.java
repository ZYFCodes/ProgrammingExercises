package org.zyf.programming.treeexercises;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述：判断一个二叉树为满二叉树
 *
 * @author yanfengzhang
 * @date 2020-05-12 20:20
 */
public class IsFullTreeNode {

    public int getTreeDepth(TreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }

        int left = getTreeDepth(pRoot.left);
        int right = getTreeDepth(pRoot.right);
        return left > right ? left + 1 : right + 1;
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        TreeNode left;
        TreeNode right;
        while (!qu.isEmpty()) {
            TreeNode tmp = qu.poll();
            left = tmp.left;
            right = tmp.right;
            if (right != null && left == null || (right == null && left != null)) {
                return false;
            }

            if (getTreeDepth(root.left) != getTreeDepth(root.right)) {
                return false;
            }

            if (left != null) {
                qu.add(left);
            }
            if (right != null) {
                qu.add(right);
            }
        }
        return true;
    }
}

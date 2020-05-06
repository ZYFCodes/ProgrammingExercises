package org.zyf.programming.treeexercises;

/**
 * 描述：二叉搜索树（BST）中的两个节点被错误地交换了，请在不改变树的结构的情况下恢复这棵树。
 *
 * @author yanfengzhang
 * @date 2020-05-06 18:19
 */
public class RecoverBST {

    private TreeNode firstErrorNode = null;
    private TreeNode secondErrorNode = null;
    private TreeNode lastNode = null;

    /**
     * 功能描述：不改变树的结构的情况下恢复二叉搜索树（BST）
     * 注意题目要求O(1)的空间。采用中序遍历来读取二叉树的值肯定是按升序排序的。
     * 所以firstErrorNode等于大于下一个节点的值的节点, secondErrorNode等于小于上一个节点的值的节点。
     *
     * @param root 具体的二叉树
     * @author yanfengzhang
     * @date 2020-05-06 18:21
     */
    public void recoverTree(TreeNode root) {
        dealCore(root);
        int temp = secondErrorNode.val;
        secondErrorNode.val = firstErrorNode.val;
        firstErrorNode.val = temp;
    }

    private void dealCore(TreeNode root) {
        if (root == null) {
            return;
        }
        dealCore(root.left);
        if (lastNode != null) {
            if (lastNode.val > root.val) {
                if (firstErrorNode == null) {
                    firstErrorNode = lastNode;
                }
                secondErrorNode = root;
            }
        }
        lastNode = root;
        dealCore(root.right);
    }
}

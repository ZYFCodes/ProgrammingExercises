package org.zyf.programming.treeexercises;

/**
 * 描述：给定一个二叉树
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * 填充所有节点的next指针，指向它右兄弟节点。如果没有右兄弟节点，则应该将next指针设置为NULL。初始时，所有的next指针都为NULL
 * 注意：只能使用常量级的额外内存空间, 可以假设给出的二叉树是一个完美的二叉树(即，所有叶子节点都位于同一层，而且每个父节点都有两个孩子节点)。
 *
 * @author yanfengzhang
 * @date 2020-05-06 15:50
 */
public class TreeLinkNodeWithNext {

    /**
     * 功能描述：填充所有节点的next指针，指向它右兄弟节点。
     *
     * @param root 当前二叉树信息
     * @author yanfengzhang
     * @date 2020-05-06 15:53
     */
    public void connect(TreeLinkNode root) {
        if (null == root) {
            return;
        }

        while (root != null) {
            /*tmpLevelFirst为新建立的每层第一个节点（为了方便后面遍历当前行节点*/
            TreeLinkNode tmpLevelFirst = new TreeLinkNode();
            TreeLinkNode cur = tmpLevelFirst;
            while (root != null) {
                if (root.left != null) {
                    cur.next = root.left;
                    cur = cur.next;
                }
                if (root.right != null) {
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = tmpLevelFirst.next;
        }
    }

    private static class TreeLinkNode {
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
    }
}

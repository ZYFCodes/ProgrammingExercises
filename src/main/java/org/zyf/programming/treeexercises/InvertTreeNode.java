package org.zyf.programming.treeexercises;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述：实现二叉树反转
 *
 * @author yanfengzhang
 * @date 2020-05-07 09:51
 */
public class InvertTreeNode {

    /**
     * 功能描述：递归方式, 最容易想到的方式最先实现
     *
     * @param root 当前树信息
     * @return 二叉树反转结果
     * @author yanfengzhang
     * @date 2020-05-07 09:56
     */
    public TreeNode invertTreeWithRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }

        /*递归反转左右子树*/
        TreeNode temp = root.left;
        root.left = invertTreeWithRecursive(root.right);
        root.right = invertTreeWithRecursive(temp);
        return root;
    }


    /**
     * 功能描述：非递归层次遍历，借助于队列，操作与栈类似，只不过元素是先进先出。
     *
     * @param root 当前树信息
     * @return 二叉树反转结果
     * @author yanfengzhang
     * @date 2020-05-07 10:11
     */
    public TreeNode invertTreeWithQueue(TreeNode root) {
        if (null == root) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            TreeNode tempLeft = temp.left;
            temp.left = temp.right;
            temp.right = tempLeft;

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return root;
    }

    /**
     * 功能描述：根据链表构建一颗二叉树
     *
     * @param inputList 输入具体的二叉树信息
     * @return TreeNode 具体的二叉树
     * @author yanfengzhang
     * @date 2020-04-30 12:11
     */
    public TreeNode createBinaryTree(LinkedList<Integer> inputList) {
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
        LinkedList<Integer> inputList = new LinkedList<Integer>(
                Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4)
        );

        InvertTreeNode invertTreeNode = new InvertTreeNode();
        TreeNode root = invertTreeNode.createBinaryTree(inputList);
        System.out.println("当前二叉树信息为：3, 2, 9, null, null, 10, null, null, 8, null, 4");
        System.out.println("当前二叉树的两种反转实现是否统一：" + invertTreeNode.invertTreeWithQueue(root).equals(invertTreeNode.invertTreeWithRecursive(root)));
    }
}

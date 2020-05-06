package org.zyf.programming.treeexercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 描述：求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 *
 * @author yanfengzhang
 * @date 2020-05-06 18:41
 */
public class MinTreeDepth {

    public int getMinTreeDepth(TreeNode root) {
        ArrayList<Integer> holder = new ArrayList<>();
        if (root == null) {
            return 0;
        }

        DFS(root, 1, holder);
        return Collections.min(holder);
    }

    private void DFS(TreeNode root, int depth, ArrayList<Integer> holder) {
        if (root.left == null && root.right == null) {
            holder.add(depth);
        }

        if (root.left != null) {
            DFS(root.left, depth + 1, holder);
        }

        if (root.right != null) {
            DFS(root.right, depth + 1, holder);
        }
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
        MinTreeDepth minTreeDepth = new MinTreeDepth();
        LinkedList<Integer> inputList = new LinkedList<Integer>(
                Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4)
        );

        TreeNode root = createBinaryTree(inputList);
        System.out.println("当前树的最小深度为：" + minTreeDepth.getMinTreeDepth(root));
    }
}

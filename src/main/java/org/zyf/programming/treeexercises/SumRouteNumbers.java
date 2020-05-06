package org.zyf.programming.treeexercises;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 描述：给定一个仅包含数字0-9的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
 * 例如根节点到叶子节点的一条路径是1->2->3,那么这条路径就用123来代替。
 * 找出根节点到叶子节点的所有路径表示的数字之和
 *
 * @author yanfengzhang
 * @date 2020-05-06 15:16
 */
public class SumRouteNumbers {

    /**
     * 功能描述：找出根节点到叶子节点的所有路径表示的数字之和
     *
     * @param root 当前二叉树信息
     * @return 根节点到叶子节点的所有路径表示的数字之和
     * @author yanfengzhang
     * @date 2020-05-06 15:40
     */
    public int sumRouteNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return preOrderSumNumbers(root, 0);
    }

    /**
     * 功能描述：先序遍历的思想(根左右)+数字求和(每一层都比上层和*10+当前根节点的值)
     *
     * @param root 当前二叉树信息
     * @return 根节点到叶子节点的所有路径表示的数字之和
     * @author yanfengzhang
     * @date 2020-05-06 15:41
     */
    private int preOrderSumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return preOrderSumNumbers(root.left, sum) + preOrderSumNumbers(root.right, sum);
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

        SumRouteNumbers sumRouteNumbers = new SumRouteNumbers();
        TreeNode root = sumRouteNumbers.createBinaryTree(inputList);
        System.out.println("当前二叉树信息为：3, 2, 9, null, null, 10, null, null, 8, null, 4");
        System.out.println("当前二叉树的根节点到叶子节点的所有路径表示的数字之和为：" + sumRouteNumbers.sumRouteNumbers(root));
    }
}

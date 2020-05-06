package org.zyf.programming.treeexercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 描述：从根节点到叶子节点的节点值之和等于sum的路径
 * 判断是否存在这样的路径+输出从根节点到叶子节点的节点值之和等于sum的所有路径
 *
 * @author yanfengzhang
 * @date 2020-05-06 16:01
 */
public class PathSum {

    ArrayList<ArrayList<Integer>> results = new ArrayList<>();

    /**
     * 功能描述：给定一个二叉树和一个值sum，判断是否有从根节点到叶子节点的节点值之和等于sum的路径
     *
     * @param root 具体的二叉树
     * @param sum  具体的和值
     * @return boolean 判断是否有从根节点到叶子节点的节点值之和等于sum的路径
     * @author yanfengzhang
     * @date 2020-05-06 16:15
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (sum == root.val && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 功能描述：输出从根节点到叶子节点的节点值之和等于sum的所有路径
     *
     * @param root 具体的二叉树
     * @param sum  具体的和值
     * @return 从根节点到叶子节点的节点值之和等于sum的所有路径
     * @author yanfengzhang
     * @date 2020-05-06 16:16
     */
    public ArrayList<ArrayList<Integer>> pathSumIsSum(TreeNode root, int sum) {
        if (root == null) {
            return results;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        pathSum(root, 0, sum, result);
        return results;
    }

    /**
     * 功能描述：输出从根节点到叶子节点的节点值之和等于sum的所有路径
     *
     * @param root   具体的二叉树
     * @param sum    具体的和值
     * @param result 从根节点到叶子节点的节点值之和等于sum的路径
     * @return 从根节点到叶子节点的节点值之和等于sum的所有路径
     * @author yanfengzhang
     * @date 2020-05-06 16:16
     */
    public void pathSum(TreeNode root, int res, int sum, ArrayList<Integer> result) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            if (res + root.val == sum) {
                result.add(root.val);
                results.add(new ArrayList<Integer>(result));
                result.remove(result.size() - 1);
            }
        } else {
            result.add(root.val);
            pathSum(root.left, res + root.val, sum, result);
            pathSum(root.right, res + root.val, sum, result);
            result.remove(result.size() - 1);
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

        PathSum pathSum = new PathSum();
        TreeNode root = pathSum.createBinaryTree(inputList);
        System.out.println("当前二叉树信息为：3, 2, 9, null, null, 10, null, null, 8, null, 4");
        System.out.println("当前二叉树是否存在这样的路径：" + pathSum.hasPathSum(root, 14));
        System.out.println("当前二叉树从根节点到叶子节点的节点值之和等于14的所有路径有：" + pathSum.pathSumIsSum(root, 14));
    }

}

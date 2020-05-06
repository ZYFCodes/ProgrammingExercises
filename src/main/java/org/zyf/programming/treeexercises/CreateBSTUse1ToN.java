package org.zyf.programming.treeexercises;

import java.util.ArrayList;

/**
 * 描述：给定一个值n,请生成所有的存储值1...n.的二叉搜索树（BST）的结构
 *
 * @author yanfengzhang
 * @date 2020-05-06 18:31
 */
public class CreateBSTUse1ToN {
    /**
     * 功能描述：给定一个值n,请生成所有的存储值1...n.的二叉搜索树（BST）的结构
     *
     * @author yanfengzhang
     * @date 2020-05-06 18:32
     */
    public ArrayList<TreeNode> generateTrees(int n) {
        return createTree(1, n);
    }

    private ArrayList<TreeNode> createTree(int low, int high) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (low > high) {
            result.add(null);
            return result;
        }
        for (int i = low; i <= high; i++) {
            /*求根结点i的左右子树集合*/
            ArrayList<TreeNode> left = createTree(low, i - 1);
            ArrayList<TreeNode> right = createTree(i + 1, high);
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    /*将左右子树相互配对，每一个左子树都与所有右子树匹配，每一个右子树都与所有的左子树匹配*/
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = left.get(j);
                    newNode.right = right.get(k);
                    result.add(newNode);
                }
            }
        }
        return result;
    }
}

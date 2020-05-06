package org.zyf.programming.dynamicprogrammingexercises;

/**
 * 描述：给定一个值n，能构建出多少不同的值包含1...n的二叉搜索树（BST）？
 * 例如: 给定 n = 3, 有五种不同的二叉搜索树（BST）
 *
 * @author yanfengzhang
 * @date 2020-05-06 18:36
 */
public class NumTreesWithN {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumTreesWithN numTreesWithN = new NumTreesWithN();
        System.out.println("给定 n = 3, 有几种不同的二叉搜索树（BST）：" + numTreesWithN.numTrees(3));
    }
}

package org.zyf.programming.dynamicprogrammingexercises;

/**
 * 描述：挖金矿问题，得到尽可能多的黄金。
 * 很久以前，有一位国王拥有5作金矿，每座金矿的黄金存量不同，需要参与挖矿的工人人数也不同。
 * 例如有的金矿存量是500kg黄金，需要5个人来挖掘；有的金矿存量是200kg，需要3个人来挖..........
 * 如果参与挖矿的工人总数是10。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
 * 要求用程序求出，要想得到可能多的黄金，应该选择挖取哪几座金矿？
 *
 * @author yanfengzhang
 * @date 2020-05-05 15:23
 */
public class GetBestGoldmining {

    /**
     * 功能描述：获得金矿最优收益
     *
     * @param w 工人数量
     * @param p 金矿开采所需工人数量
     * @param g 金矿储量
     * @return 金矿最优收益
     * @author yanfengzhang
     * @date 2020-05-05 15:34
     */
    public static int getBestGoldMining(int w, int[] p, int[] g) {
        /*创建当前结果*/
        int[] results = new int[w + 1];
        /*填充一维数组*/
        for (int i = 1; i <= g.length; i++) {
            for (int j = w; j >= 1; j--) {
                if (j >= p[i - 1]) {
                    results[j] = Math.max(results[j], results[j - p[i - 1]] + g[i - 1]);
                }
            }
        }
        /*返回最后一个格子的值*/
        return results[w];
    }

    public static void main(String[] args) {
        int w = 10;
        int[] p = {5, 5, 3, 4, 3};
        int[] g = {400, 500, 200, 300, 350};
        System.out.println("最优收益：" + getBestGoldMining(w, p, g));
    }
}

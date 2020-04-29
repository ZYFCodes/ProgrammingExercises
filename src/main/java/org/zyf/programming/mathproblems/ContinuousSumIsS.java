package org.zyf.programming.mathproblems;

import java.util.ArrayList;

/**
 * 描述：和为S的连续正数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck! 
 *
 * @author yanfengzhang
 * @date 2020-04-29 15:51
 */
public class ContinuousSumIsS {

    /**
     * 功能描述：考虑用两个数 small 和 big 分别表示序列的最小值和最大值。首先把 small 初始化为 1，big 初始化为 2。
     * 如果从 small 到 big 的序列的和大于等于 s，我们可以从序列中去掉较小的值，也就是增大 small 的值。
     * 如果从 small 到 big 的序列的和小于 s，我们可以增大 big，让这个序列包含更多的数字。 
     * 因为这个序列至少要有两个数字，我们一直增加 small 到(1+s)/2 为止 。
     *
     * @param sum 具体的和值
     * @return ArrayList<ArrayList < Integer>> 所有符合要求的值
     * @author yanfengzhang
     * @date 2020-04-29 16:14
     */
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int small = 1;
        int big = 2;
        int middle = (1 + sum) >> 1;
        int currentSum = small + big;
        while (small < middle) {
            if (currentSum > sum) {
                currentSum -= small++;
            } else if (currentSum < sum) {
                currentSum += big++;
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                result.add(list);
                currentSum -= small++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println("找到和为92的连续序列：" + findContinuousSequence(92));
    }
}

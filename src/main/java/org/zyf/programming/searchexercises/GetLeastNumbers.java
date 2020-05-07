package org.zyf.programming.searchexercises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 描述：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 *
 * @author yanfengzhang
 * @date 2020-05-07 11:53
 */
public class GetLeastNumbers {

    /**
     * 功能描述：如果数据很大，面对海量数据时，能不能使得时间复杂度较低且快速完成任务？
     * 我们可以先创建一个大小为K的数据容器来存储最小的K个数字，接下来我们每次从输入的n个整数中读入一个数。
     * 如果容器中已有的数字少于K个，则直接把这次读入的整数放入到容器中；如果容器中已有K个数字了，就说明容器已满，此时我们不能再插入新的数字而只能替换已有的数字。
     * 当容器满了，我们要做三件事：
     * 一是在K个整数中找到最大数；二是有可能在这个容器中删除最大数；三是有可能插入一个新的数。
     * 找到已有的K个数中的最大值，然后拿这次待插入的整数和最大值进行比较。
     * 如果待插入的值比当前已有的最大值小，则用这个数替换当前已有的最大值；
     * 如果待插入的值比当前已有的最大值还要大，那么这个数不可能是最小的K个整数之一，我们抛弃这个整数。
     * 选择不同的二叉树来实现这个容器，自然想到的就是最大堆或红黑树
     *
     * @param input 具体的数组
     * @param k     最小的K位数
     * @return 找出其中最小的K个数
     * @author yanfengzhang
     * @date 2020-05-07 12:00
     */
    public static ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        ArrayList<Integer> leastNum = new ArrayList<Integer>();
        if (input == null || input.length < 1 || k < 1 || k > input.length) {
            return leastNum;
        }
        TreeSet<Integer> kSet = new TreeSet<Integer>();
        for (int i = 0; i < input.length; i++) {
            if (kSet.size() < k) {
                kSet.add(input[i]);
            } else {
                if (input[i] < kSet.last()) {
                    kSet.remove(kSet.last());
                    kSet.add(input[i]);
                }
            }
        }
        Iterator<Integer> it = kSet.iterator();
        while (it.hasNext()) {
            leastNum.add(it.next());
        }
        return leastNum;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println("输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是" + getLeastNumbers(input, 4));
    }
}

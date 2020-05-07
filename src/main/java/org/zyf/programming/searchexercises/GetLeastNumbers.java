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

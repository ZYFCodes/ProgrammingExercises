package org.zyf.programming.arrayexercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：在数组中找到和为 S 的两个数的组合
 *
 * @author yanfengzhang
 * @date 2020-04-29 14:59
 */
public class SumIsS {

    /**
     * 功能描述：在递增的数组中找到和为S的两个数的组合,输出任意一对
     *
     * @param array 排序数组
     * @param sum   具体和
     * @return ArrayList<Integer>
     * @author yanfengzhang
     * @date 2020-04-29 15:05
     */
    public static ArrayList<Integer> FindNumbersWithSumInSortedArray(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (null == array || array.length < 2) {
            return result;
        }

        int index1 = 0;
        int index2 = array.length - 1;
        while (index1 < index2) {
            if (array[index1] + array[index2] == sum) {
                result.add(array[index1]);
                result.add(array[index2]);
                return result;
            } else if (array[index1] + array[index2] > sum) {
                index2--;
            } else {
                index1++;
            }
        }

        return result;
    }

    /**
     * 功能描述：在数组中找到和为S的两个数的组合,输出任意一对
     *
     * @param array 排序数组
     * @param sum   具体和
     * @return ArrayList<Integer>
     * @author yanfengzhang
     * @date 2020-04-29 15:05
     */
    public static ArrayList<Integer> FindNumbersWithSumInNoSortedArray(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (null == array || array.length <= 0) {
            return result;
        }
        Map tempMap = new HashMap();
        for (int i = 0; i < array.length; i++) {
            tempMap.put(array[i], "");
        }

        for (int i = 0; i < array.length; i++) {
            int otherNumber = sum - array[i];
            if (tempMap.containsKey(otherNumber)) {
                result.add(array[i]);
                result.add(otherNumber);
                return result;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        /*
         * 对于排序数组情况
         */
        int[] array1 = {1, 3, 4, 5, 6, 8, 9, 11, 34, 56, 78, 88, 89, 93};
        /*
         * 对于非排序数组情况
         */
        int[] array2 = {23, 15, 26, 23, 28, 52, 82, 100, 101, 33, 42, 57, 87};

        System.out.println("当前有序数组为：" + Arrays.toString(array1));
        System.out.println("其中任意一对和为90的数为：" + FindNumbersWithSumInSortedArray(array1, 90));
        System.out.println("当前无序数组为：" + Arrays.toString(array2));
        System.out.println("其中任意一对和为182的数为：" + FindNumbersWithSumInNoSortedArray(array2, 182));
    }
}

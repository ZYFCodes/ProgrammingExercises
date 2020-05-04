package org.zyf.programming.sortexercises;

import java.util.Arrays;

/**
 * 描述：有一个无序数组，求出该数组排序后的任意两个相邻元素的最大值。
 * 要求：时间复杂度要尽量的低，最好为O(n)
 *
 * @author yanfengzhang
 * @date 2020-05-04 20:22
 */
public class GetMaxDistanceWithBucket {

    /**
     * 功能描述：求出该数组排序后的任意两个相邻元素的最大值
     *
     * @param array 具体数组
     * @return int 任意两个相邻元素的最大值
     * @author yanfengzhang
     * @date 2020-05-04 21:06
     */
    public static int getMaxSortedDistance(int[] array) {
        if (null == array || array.length <= 1) {
            return 0;
        }

        /*1.得到数列的最大值和最小值*/
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] < min) {
                min = array[i];
            }

            if (array[i] > max) {
                max = array[i];
            }
        }

        int difference = max - min;
        if (difference == 0) {
            return 0;
        }

        /*2.初始化桶*/
        int bucketNumber = array.length;
        Bucket[] buckets = new Bucket[bucketNumber];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }


        /*3.遍历原始数组，确定每个桶的最大值和最小值*/
        for (int i = 0; i < array.length; i++) {
            int index = (array[i] - min) * (bucketNumber - 1) / difference;
            if (buckets[index].min == null || buckets[index].min > array[i]) {
                buckets[index].min = array[i];
            }
            if (buckets[index].max == null || buckets[index].max < array[i]) {
                buckets[index].max = array[i];
            }
        }

        /*4.遍历桶，找到最大差值*/
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }

            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }

        return maxDistance;
    }


    /**
     * 功能描述：桶的具体结构
     *
     * @author yanfengzhang
     * @date 2020-05-04 21:07
     */
    private static class Bucket {
        Integer min;
        Integer max;
    }

    public static void main(String[] args) {
        int[] array1 = {2, 6, 3, 4, 5, 10, 9, 7, 34, 0, 21, 16, 18, 23, 27, 29, 33};
        System.out.println("原数组为：" + Arrays.toString(array1));
        System.out.println("该数组排序后的任意两个相邻元素的最大值：" + getMaxSortedDistance(array1));
        int[] array2 = {2, 6, 3, 4, 5, 10, 9, 7, 34, 0, 21, 16, 18, 23, 27, 29, 33};
        QuickSort.sort(array2);
        System.out.println("原数组排序后的情况为：" + Arrays.toString(array2));

    }
}



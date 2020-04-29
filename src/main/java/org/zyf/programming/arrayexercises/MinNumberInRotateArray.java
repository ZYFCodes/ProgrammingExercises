package org.zyf.programming.arrayexercises;

import java.util.Arrays;

/**
 * 描述：找到排序数组中的最小值
 *
 * @author yanfengzhang
 * @date 2020-04-29 13:54
 */
public class MinNumberInRotateArray {

    /**
     * 功能描述：注意情况的划分
     * @author yanfengzhang
     * @date 2020-04-29 14:52
     * @param array
     * @return int
    */
    public static int minNumberInRotateArray(int[] array) {
        if (null == array || array.length <= 0) {
            return 0;
        }
        /*标注最小值的下标*/
        int minIndex = 0;
        int index1 = 0;
        int index2 = array.length - 1;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                minIndex = index2;
                break;
            }

            if (array[index1] == array[index2]) {
                int base = array[index1];
                for (int i = index1 + 1; i < index2; i++) {
                    if (base > array[i]) {
                        minIndex = i;
                    }
                    break;
                }
            }

            int middleIndex = (index1 + index2) >> 1;
            if (array[middleIndex] > array[index1]) {
                index1 = middleIndex;
                minIndex = middleIndex;
            } else if (array[middleIndex] <= array[index2]) {
                index2 = middleIndex;
                minIndex = middleIndex;
            }

        }
        return array[minIndex];
    }

    public static void main(String[] args) {
        /*
         * 一般情况
         */
        int[] array1 = {3, 4, 5, 1, 2, 2};
        /*
         * 特殊情况
         */
        int[] array2 = {2, 1, 2, 2, 2, 2, 2};

        System.out.println("当前旋转数组为：" + Arrays.toString(array1));
        System.out.println("其中最小的数为：" + minNumberInRotateArray(array1));
        System.out.println("当前旋转数组为：" + Arrays.toString(array2));
        System.out.println("其中最小的数为：" + minNumberInRotateArray(array2));
    }
}

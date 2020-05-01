package org.zyf.programming.sortexercises;

import java.util.Arrays;

/**
 * 描述：实现冒泡排序
 * 要求：符合数列有序区的界定和基本有序的界定，减少不必要的交换次数
 *
 * @author yanfengzhang
 * @date 2020-05-01 17:13
 */
public class BubbleSort {

    /**
     * 功能描述：实现冒泡排序
     *
     * @param array 需要进行排序的数组
     * @author yanfengzhang
     * @date 2020-05-01 17:42
     */
    public static void sort(int[] array) {
        if (array == null || array.length <= 0) {
            return;
        }

        /*记录最后一次交换的位置*/
        int lastExchangeIndex = 0;
        /*无序数列的边界，每次比较只需要比到这里为止*/
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            /*有序标记，每一轮的初始值都是true*/
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    /*因为有元素进行交换了，所以不是有序的，标记变为false*/
                    isSorted = false;
                    /*更新为最后一次交换元素的位置*/
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {3, 4, 2, 1, 5, 6, 7, 8, 6, 0, 12, 34, 56};
        System.out.println("原数组为：" + Arrays.toString(array));
        sort(array);
        System.out.println("进行冒泡排序后的数组为：" + Arrays.toString(array));
    }
}

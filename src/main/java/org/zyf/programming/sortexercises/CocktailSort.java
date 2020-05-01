package org.zyf.programming.sortexercises;

import java.util.Arrays;

/**
 * 描述：鸡尾酒排序，减少排序回合数
 * 暂时没有考虑有序区的优化
 *
 * @author yanfengzhang
 * @date 2020-05-01 17:43
 */
public class CocktailSort {

    /**
     * 功能描述：鸡尾酒排序，暂时没有考虑有序区的优化
     *
     * @param array 需要进行排序的数组
     * @author yanfengzhang
     * @date 2020-05-01 17:58
     */
    public static void sort(int[] array) {
        if (array == null || array.length <= 0) {
            return;
        }

        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            /*有序标记，每一轮的初始值都是true*/
            boolean isSorted = true;
            /*奇数轮，从左到右比较和交换*/
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    /*因为有元素进行交换了，所以不是有序的，标记变为false*/
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }

            /*在进行偶数轮之前，将isSorted重新标记为true*/
            isSorted = true;
            /*偶数轮，从右向左比较*/
            for (int j = array.length - 1 - i; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    /*因为有元素进行交换了，所以不是有序的，标记变为false*/
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 2, 1, 5, 6, 7, 8, 6, 0, 12, 34, 56};
        System.out.println("原数组为：" + Arrays.toString(array));
        sort(array);
        System.out.println("进行鸡尾酒排序后的数组为：" + Arrays.toString(array));
    }
}

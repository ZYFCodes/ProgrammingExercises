package org.zyf.programming.sortexercises;

import java.util.Arrays;

/**
 * 描述：归并排序
 *
 * @author yanfengzhang
 * @date 2020-05-01 20:00
 */
public class MergeSort {

    /**
     * 功能描述：归并排序
     *
     * @param array 需要进行排序的数组
     * @author yanfengzhang
     * @date 2020-05-01 21:32
     */
    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        /*在排序前先建好一个长度等于原数组长度的临时数组*/
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
    }

    /**
     * 功能描述：归并排序
     *
     * @param array 需要进行排序的数组
     * @author yanfengzhang
     * @date 2020-05-01 21:33
     */
    private static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) >> 1;
        /*左边递归排序，是的左子序列有序*/
        mergeSort(array, left, mid, temp);
        /*右边递归排序，是的右子序列有序*/
        mergeSort(array, mid + 1, right, temp);
        /*将两个有序子数组合并*/
        merge(array, left, mid, right, temp);
    }

    /**
     * 功能描述：合并有序数组
     *
     * @param array 需要进行排序的数组
     * @author yanfengzhang
     * @date 2020-05-01 21:34
     */
    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        /*左序列指针*/
        int i = left;
        /*右序列指针*/
        int j = mid + 1;
        /*临时数组指针*/
        int t = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }

        /*将左边剩余元素填充进temp中*/
        while (i <= mid) {
            temp[t++] = array[i++];
        }

        /*将右边剩余元素填充进temp中*/
        while (j <= right) {
            temp[t++] = array[j++];
        }

        t = 0;
        /*将temp中的元素全部拷贝到原数组中*/
        while (left <= right) {
            array[left++] = temp[t++];
        }
    }


    public static void main(String[] args) {
        int[] array = {3, 4, 2, 1, 5, 6, 7, 8, 6, 0, 12, 34, 56};
        System.out.println("原数组为：" + Arrays.toString(array));
        sort(array);
        System.out.println("进行归并排序后的数组为：" + Arrays.toString(array));
    }
}

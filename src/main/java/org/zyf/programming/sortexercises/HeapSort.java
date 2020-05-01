package org.zyf.programming.sortexercises;

import java.util.Arrays;

/**
 * 描述：堆排序
 *
 * @author yanfengzhang
 * @date 2020-05-01 21:54
 */
public class HeapSort {

    /**
     * 功能描述：堆排序(升序)
     *
     * @param array 待调整的堆
     * @author yanfengzhang
     * @date 2020-05-01 21:55
     */
    public static void heapSort(int[] array) {
        /*1.把无序数组构建成最大堆。*/
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        /*2.循环交换集合尾部元素到堆顶，并调节堆产生新的堆顶。*/
        for (int i = array.length - 1; i > 0; i--) {
            /*最后一个元素和第一元素进行交换*/
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            /*下沉调整最大堆*/
            downAdjust(array, 0, i);
        }
    }

    /**
     * 功能描述：下沉调整
     *
     * @param array       待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length      堆的有效大小
     * @author yanfengzhang
     * @date 2020-05-01 21:56
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        /*temp保存父节点值，用于最后的赋值*/
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            /*如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子*/
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            /*如果父节点大于等于任何一个孩子的值，直接跳出*/
            if (temp >= array[childIndex]) {
                break;
            }
            /*无需真正交换，单向赋值即可*/
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 2, 1, 5, 6, 7, 8, 6, 0, 12, 34, 56};
        System.out.println("原数组为：" + Arrays.toString(array));
        heapSort(array);
        System.out.println("进行堆排序后的数组为：" + Arrays.toString(array));
    }
}

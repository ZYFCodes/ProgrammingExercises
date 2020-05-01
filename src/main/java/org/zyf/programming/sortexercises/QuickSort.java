package org.zyf.programming.sortexercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 描述：快速排序
 * 核心问题1：基准元素的选择  优化方向：随机取数或三数取中或九数取中
 * 核心问题2：元素的交换   双边循环法或单边循环法
 *
 * @author yanfengzhang
 * @date 2020-05-01 18:43
 */
public class QuickSort {

    /**
     * 功能描述：进行快速排序
     * @author yanfengzhang
     * @date 2020-05-01 19:51
     * @param array 需要进行排序的数组
    */
    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int startIndex = 0;
        int endIndex = array.length - 1;
        quickSort(array, startIndex, endIndex);
    }

    /**
     * 功能描述：采用递归方式进行快速排序
     * @author yanfengzhang
     * @date 2020-05-01 19:52
     * @param array 需要进行排序的数组
    */
    public static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(array, startIndex, endIndex);
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    public static void quickSortWithStack(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        /*用一个集合栈来代替递归的数据栈*/
        Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();
        /*整个数列的起始下标，以哈希的形式入栈*/
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        while (!quickSortStack.isEmpty()) {
            /*栈顶元素出栈*/
            Map<String, Integer> param = quickSortStack.pop();
            /*得到基准元素位置*/
            int pivotIndex = partition(array, param.get("startIndex"), param.get("endIndex"));
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            } else if (pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }

        }
    }

    public static int partition(int[] array, int startIndex, int endIndex) {
        /*选取第一个位置（也可以是随机）的元素作为基准元素*/
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            /*控制right指针比较并左移*/
            while (left < right && array[right] > pivot) {
                right--;
            }
            /*控制left指针比较并右移*/
            while (left < right && array[left] <= pivot) {
                left++;
            }

            /*交换left和right指针所指的元素*/
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        /*pivot和指针重合点交换*/
        array[startIndex] = array[left];
        array[left] = pivot;

        return left;
    }

    public static void main(String[] args) {
        int[] array1 = {3, 4, 2, 1, 5, 6, 7, 8, 6, 0, 12, 34, 56};
        System.out.println("原数组为：" + Arrays.toString(array1));
        sort(array1);
        System.out.println("进行冒快速排序(采用递归)后的数组为：" + Arrays.toString(array1));
        int[] array2 = {3, 4, 2, 1, 5, 6, 7, 8, 6, 0, 12, 34, 56};
        System.out.println("原数组为：" + Arrays.toString(array2));
        quickSortWithStack(array2, 0, array2.length - 1);
        System.out.println("进行冒快速排序（采用非递归）后的数组为：" + Arrays.toString(array2));
    }
}

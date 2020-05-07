package org.zyf.programming.arrayexercises;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：数组当中存在奇数和偶数，将数组进行排序，使得所有奇数位于偶数前面，原位置相对不变
 *
 * @author yanfengzhang
 * @date 2020-04-29 10:38
 */
public class EvenAndOdd {

    /**
     * 功能描述：将数组进行排序，使得所有奇数位于偶数前面，原位置相对不变
     *
     * @param array
     * @author yanfengzhang
     * @date 2020-04-29 10:45
     */
    public static void evenBeforeOdd(int[] array) {
        if (null == array || array.length <= 0) {
            return;
        }

        int i = 0, j;
        while (i < array.length) {
            while (i < array.length && !isEven(array[i])) {
                i++;
            }
            j = i + 1;
            while (j < array.length && isEven(array[j])) {
                j++;
            }

            if (j < array.length) {
                int tmp = array[j];
                for (int j2 = j - 1; j2 >= i; j2--) {
                    array[j2 + 1] = array[j2];
                }
                array[i++] = tmp;
            } else {// 查找失敗
                break;
            }
        }

    }

    /**
     * 功能描述：降低时间复杂度---且不消耗空间
     *
     * @param array
     * @author yanfengzhang
     * @date 2020-04-29 13:57
     */
    public static void reOrderArray(int[] array) {
        int evenIdx = -1;
        boolean firstEven = true;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (firstEven == true) {
                    evenIdx = i;
                    firstEven = false;
                }
            } else {
                if (evenIdx != -1) {
                    int evenEnd = i - 1;
                    int tmpOdd = array[i];
                    for (int j = evenEnd; j >= evenIdx; j--) {

                        array[j + 1] = array[j];

                    }
                    array[evenIdx] = tmpOdd;
                    evenIdx++;
                }
            }
        }
    }

    /**
     * 功能描述：用空间复杂度换取时间复杂度
     * @author yanfengzhang
     * @date 2020-04-29 13:58
     * @param array
    */
    public static void useMem(int[] array) {
        if (null == array || array.length <= 0) {
            return;
        }

        List<Integer> evenList = new ArrayList<Integer>();
        List<Integer> oddList = new ArrayList<Integer>();

        for (int i = 0; i < array.length - 1; i++) {
            if (isEven(array[i])) {
                evenList.add(array[i]);
            } else {
                oddList.add(array[i]);
            }
        }

        int oddCount = oddList.size();
        for (int i = 0; i < oddList.size(); i++) {
            array[i] = oddList.get(i);
        }

        for (int i = 0; i < evenList.size(); i++) {
            array[oddCount + i] = evenList.get(i);
        }
    }

    /**
     * 功能描述：判断当前数是否为偶数
     *
     * @param number
     * @return boolean
     * @author yanfengzhang
     * @date 2020-04-29 10:58
     */
    private static boolean isEven(int number) {
        if ((number & 1) == 0) {
            return true;
        }
        return false;
    }


    /**
     * 功能描述：进行打印验证
     * @author yanfengzhang
     * @date 2020-04-29 13:59
     * @param array
    */
    public static void toString(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 2, 4, 6, 8, 4, 78, 54, 890, 234, 53, 6, 7, 443, 67, 4, 3, 4};
        int[] array2 = {54, 890, 234, 53, 6, 7, 443, 67, 4, 3, 4, 3, 5, 2, 4, 6, 8, 4, 78};
        int[] array3 = {1, 3, 5, 2, 4, 6, 8, 4, 78, 54, 890, 234, 53, 6, 7, 443, 67, 4, 3, 4, 6};
        int[] array4 = {54, 890, 234, 53, 6, 7, 443, 67, 4, 3, 4, 3, 5, 2, 4, 6, 8, 4, 78, 55};
        int[] array5 = {1, 3, 5, 2, 4, 6, 8, 4, 78, 54, 890, 234, 53, 6, 7, 443, 67, 4, 3, 4, 6, 90};
        int[] array6 = {54, 890, 234, 53, 6, 7, 443, 67, 4, 3, 4, 3, 5, 2, 4, 6, 8, 4, 78, 55};

        System.out.print("当原数组为：");
        toString(array1);

        evenBeforeOdd(array1);
        System.out.print("进行整理后为：");
        toString(array1);

        System.out.print("原数组为：");
        toString(array2);

        evenBeforeOdd(array2);
        System.out.print("进行整理后为：");
        toString(array2);

        System.out.println("=======================");

        System.out.print("当原数组为：");
        toString(array3);

        reOrderArray(array3);
        System.out.print("进行整理后为：");
        toString(array3);

        System.out.print("原数组为：");
        toString(array4);

        reOrderArray(array4);
        System.out.print("进行整理后为：");
        toString(array4);

        System.out.println("=======================");

        System.out.print("当原数组为：");
        toString(array5);

        useMem(array5);
        System.out.print("进行整理后为：");
        toString(array5);

        System.out.print("原数组为：");
        toString(array6);

        useMem(array6);
        System.out.print("进行整理后为：");
        toString(array6);

    }
}

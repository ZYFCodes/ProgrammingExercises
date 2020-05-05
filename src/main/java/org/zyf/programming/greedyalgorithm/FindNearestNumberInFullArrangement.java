package org.zyf.programming.greedyalgorithm;

import java.util.Arrays;

/**
 * 描述：获取全排列的下一个数
 * 需要三个基本步骤：
 * 1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
 * 2.让逆序区域的前一位和逆序区域中大于它的最小数字交换位置
 * 3.把原来的逆序区域转换为顺序状态
 *
 * @author yanfengzhang
 * @date 2020-05-05 00:34
 */
public class FindNearestNumberInFullArrangement {

    /**
     * 功能描述：获取全排列的下一个数
     *
     * @param numbers 当前数组排列数字
     * @return 全排列的下一个数
     * @author yanfengzhang
     * @date 2020-05-05 13:27
     */
    public static int[] findNearestNumberInFullArrangement(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return null;
        }
        /*1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界*/
        int index = findTransferPoint(numbers);
        /*如果数字置换边界是0，说明整个数组已经逆序，无法得到更大的相同数字组成的数字，返回null*/
        if (index == 0) {
            return null;
        }

        /*2.把逆序区域的前一位和逆序区域中大于它的最小数字交换位置，复制并入参*/
        /*复制并入参，避免直接修改入参*/
        int[] numberCopy = Arrays.copyOf(numbers, numbers.length);
        exchangeHead(numberCopy, index);

        /*3.把原来的逆序区域转换为顺序状态*/
        reverse(numberCopy, index);

        return numberCopy;
    }

    /**
     * 功能描述：从后向前查看逆序区域，找到逆序区域的前一位
     *
     * @param numbers 当前数组排列数字
     * @return 逆序区域的前一位下标
     * @author yanfengzhang
     * @date 2020-05-05 13:29
     */
    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 功能描述：逆序区域的前一位和逆序区域中大于它的最小数字交换位置
     *
     * @author yanfengzhang
     * @date 2020-05-05 13:30
     */
    private static int[] exchangeHead(int[] numberCopy, int index) {
        int head = numberCopy[index - 1];
        for (int i = numberCopy.length - 1; i > 0; i--) {
            if (head < numberCopy[i]) {
                numberCopy[index - 1] = numberCopy[i];
                numberCopy[i] = head;
                break;
            }
        }
        return numberCopy;
    }

    /**
     * 功能描述：把原来的逆序区域转换为顺序状态
     *
     * @author yanfengzhang
     * @date 2020-05-05 13:30
     */
    private static int[] reverse(int[] numberCopy, int index) {
        for (int i = index, j = numberCopy.length - 1; i < j; i++, j--) {
            int temp = numberCopy[i];
            numberCopy[i] = numberCopy[j];
            numberCopy[j] = temp;
        }
        return numberCopy;
    }


    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4, 5};
        for (int i = 0; i < 10; i++) {
            number = findNearestNumberInFullArrangement(number);
            System.out.println(Arrays.toString(number));
        }
    }
}

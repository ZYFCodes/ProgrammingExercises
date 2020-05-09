package org.zyf.programming.dynamicprogrammingexercises;

/**
 * 描述：正整数N从1开始，每次操作可以选择对N加1或者对N乘2.若想获得正整数M，最少需要多少个操作。
 *
 * @author yanfengzhang
 * @date 2020-05-08 17:09
 */
public class MinOptionsToM {

    /**
     * 功能描述：正整数N从1开始，每次操作可以选择对N加1或者对N乘2.若想获得正整数M，最少需要多少个操作。
     * 动态规划：5-->3  5=1+1*2+1*2 (3次)
     * 31=15*2+1    （2次）
     * 15=7*2+1     （2次）
     * 7=3*2+1      （2次）
     * 3=1*2+1      （2次）
     *
     * @param m 输入一个正整数M，表示期望获得的正整数；1 < M < 65536
     * @return 为一个整数，表示得到正整数M需要执行的操作数；如果输入数值错误输出-1
     * @author yanfengzhang
     * @date 2020-05-08 17:11
     */
    public static int minOptionsToM(int m) {
        /*进行检测，检测不通过直接返回-1*/
        if (m <= 1 || m > 65536) {
            return -1;
        }

        if (m == 2) {
            return 1;
        }

        int[] nums = new int[m + 1];
        nums[0] = -1;
        nums[1] = -1;
        nums[2] = 1;
        for (int i = 3; i <= m; i++) {
            if (i % 2 == 0) {
                nums[i] = (nums[i - 1] < nums[i / 2]) ? nums[i - 1]
                        + 1 : nums[i / 2] + 1;
            } else {
                nums[i] = nums[i - 1] + 1;
            }
        }
        return nums[m];
    }

    public static void main(String[] args) {
        System.out.println("正整数N从1开始，每次操作可以选择对N加1或者对N乘2.若想获得正整数5，最少需要操作数为：" + minOptionsToM(5));
    }
}

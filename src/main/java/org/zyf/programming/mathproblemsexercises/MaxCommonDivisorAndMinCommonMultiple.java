package org.zyf.programming.mathproblemsexercises;

/**
 * 描述：最大公约数和最小公倍数
 *
 * @author yanfengzhang
 * @date 2020-04-30 16:41
 */
public class MaxCommonDivisorAndMinCommonMultiple {

    /**
     * 功能描述：最大公约数
     *
     * @param m n 具体常数
     * @return int 最大公约数
     * @author yanfengzhang
     * @date 2020-04-30 16:57
     */
    public static int maxCommonDivisor(int m, int n) {
        if (m == n) {
            return m;
        }
        if ((m & 1) == 0 && (n & 1) == 0) {
            return maxCommonDivisor(m >> 1, n >> 1) << 1;
        } else if ((m & 1) == 0 && (n & 1) != 0) {
            return maxCommonDivisor(m >> 1, n);
        } else if ((m & 1) != 0 && (n & 1) == 0) {
            return maxCommonDivisor(m, n >> 1);
        } else {
            int big = m > n ? m : n;
            int small = m < n ? m : n;
            return maxCommonDivisor(big - small, small);
        }
    }

    /**
     * 功能描述：最小公倍数
     *
     * @param m n 具体常数
     * @return int 最小公倍数
     * @author yanfengzhang
     * @date 2020-04-30 16:58
     */
    public static int minCommonMultiple(int m, int n) {
        return m * n / maxCommonDivisor(m, n);
    }

    public static void main(String[] args) {
        int m = 8;
        int n = 12;
        System.out.println("当前有两个整数，分别为8和12。");
        System.out.println("这两个数的最大公约数为" + maxCommonDivisor(m, n));
        System.out.println("这两个数的最小公倍数为" + minCommonMultiple(m, n));
    }
}

package org.zyf.programming.mathproblemsexercises;

/**
 * 描述：求一个数的平方根
 *
 * @author yanfengzhang
 * @date 2020-05-05 17:04
 */
public class Sqrt {

    /**
     * 功能描述：求一个数的平方根
     *
     * @param x 具体的整数
     * @return 返回对应平方根
     * @author yanfengzhang
     * @date 2020-05-05 17:06
     */
    public static int getSqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long left = 1;
        long right = x;

        while (left <= right) {
            long mid = (right + left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            }
            if (mid * mid < x) {
                left = (int) mid + 1;
            }
            if (mid * mid > x) {
                right = (int) mid - 1;
            }
        }
        if (right * right < x) {
            return (int) right;
        } else {
            return (int) left;
        }
    }

    public static void main(String[] args) {
        System.out.println("100的平方根为：" + getSqrt(100));
    }

}

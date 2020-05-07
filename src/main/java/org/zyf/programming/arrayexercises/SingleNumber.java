package org.zyf.programming.arrayexercises;

/**
 * 描述：找出只出现一次的元素
 *
 * @author yanfengzhang
 * @date 2020-05-07 13:32
 */
public class SingleNumber {

    /**
     * 功能描述：现在有一个整数类型的数组，数组中只有一个元素只出现一次，其余的元素都出现两次。
     * 思路：两个相同的数异或为0
     *
     * @param array 整数类型的数组
     * @return 数组中只有一个元素只出现一次
     * @author yanfengzhang
     * @date 2020-05-07 13:33
     */
    public int getSingleNumberInTwo(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];
        }

        return result;
    }

    /**
     * 功能描述：现在有一个整数类型的数组，数组中只有一个元素只出现一次，其余元素都出现三次。找出只出现一次的元素!
     * Single Number的本质，就是用一个数记录每个bit出现的次数，如果一个bit出现两次就归0，这种运算采用二进制底下的位操作^是很自然的。
     * Single Number II中，如果能定义三进制底下的某种位操作，也可以达到相同的效果，Single Number II中想要记录每个bit出现的次数，一个数搞不定就加两个数，
     * 用ones来记录只出现过一次的bits，用twos来记录只出现过两次的bits，ones&twos实际上就记录了出现过三次的bits，
     * 这时候我们来模拟进行出现3次就抵消为0的操作，抹去ones和twos中都为1的bits。
     *
     * @param array 整数类型的数组
     * @return 数组中只有一个元素只出现一次
     * @author yanfengzhang
     * @date 2020-05-07 13:38
     */
    public int getSingleNumberInThree(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        /*记录只出现过1次的bits*/
        int ones = 0;
        /*记录只出现过2次的bits*/
        int twos = 0;
        int threes;
        for (int i = 0; i < array.length; i++) {
            int t = array[i];
            /*要在更新ones前面更新twos*/
            twos |= ones & t;
            ones ^= t;
            /*ones和twos中都为1即出现了3次*/
            threes = ones & twos;
            /*抹去出现了3次的bits*/
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 2, 4, 6, 8, 1, 5, 7, 9, 0};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 2, 3, 4, 6, 7, 2, 3, 4, 6, 7, 1, 4, 8, 1, 4, 8};

        SingleNumber singleNumber = new SingleNumber();
        System.out.println("数组【】中只有一个元素只出现一次，其余的元素都出现两次，这个出现一次的数是：" + singleNumber.getSingleNumberInTwo(array1));
        System.out.println("数组【】中只有一个元素只出现一次，其余元素都出现三次，只出现一次的元素是：" + singleNumber.getSingleNumberInThree(array2));
    }

}

package cn.infomany.leetcode;

/**
 * 7. 整数反转
 *
 * @author zjb
 * @date 2020/6/25
 */
public class Q7IntegerInversion {

    /**
     * ####题目描述：
     * >给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * ##### 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     * ##### 示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */

    public static void main(String[] args) {
        System.out.println(new Q7IntegerInversion().reverse(-123));
        System.out.println(new Q7IntegerInversion().reverse(Integer.MIN_VALUE));
        System.out.println(new Q7IntegerInversion().reverse(1563847412));
        System.out.println(new Q7IntegerInversion().reverse(Integer.MAX_VALUE));
        System.out.println(new Q7IntegerInversion().reverse(901000));
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        long res = 0;
        while (x != 0) {
            int idx = x % 10;
            x /= 10;
            res = res * 10 + idx;
        }
        return (int) res == res ? (int) res : 0;
    }

}

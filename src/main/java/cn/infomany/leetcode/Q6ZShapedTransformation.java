package cn.infomany.leetcode;

/**
 * 6. Z 字形变换
 *
 * @author zjb
 * @date 2020/6/25
 */
public class Q6ZShapedTransformation {

    /**
     * ####题目描述：
     * >将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * <p>
     * 请你实现这个将字符串进行指定行数变换的函数：
     * <p>
     * string convert(string s, int numRows);
     * <p>
     * ##### 示例 1:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * ##### 示例 2:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     */

    public static void main(String[] args) {
        String leetcodeishiring = new Q6ZShapedTransformation().convert("AB", 1);
        System.out.println("leetcodeishiring = " + leetcodeishiring);
    }

    public String convert(String s, int numRows) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        // 一行或者字符串的长度小于行数时直接返回
        if (numRows == 1 || len <= numRows) {
            return s;
        }

        char[] convertChar = new char[len];
        int k = 0;
        for (int i = 0; i < numRows; i++) {
            boolean door = true;
            for (int j = i; j < len && k < len; ) {
                convertChar[k++] = s.charAt(j);

                if (i == 0 || i == numRows - 1) {
                    j += numRows * 2 - 2;
                    continue;
                }
                if (door) {
                    j += numRows * 2 - 2 - i * 2;
                } else {
                    j += 2 * i;
                }
                door = !door;
            }
        }
        return new String(convertChar);
    }
}

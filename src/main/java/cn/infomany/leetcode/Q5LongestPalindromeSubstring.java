package cn.infomany.leetcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 5. 最长回文子串
 *
 * @author zjb
 * @date 2020/6/25
 */
public class Q5LongestPalindromeSubstring {
    /**
     * ####题目描述：
     * >给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * #####示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * ##### 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     */
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len <= 1) {
            return s;
        }

        String maxSub = getTheTwoHalvesTheLongestEqual(s, len);
        if (maxSub.length() >= len - 1) {
            return maxSub;
        }
        Set<String> subList = new HashSet<>();
        subList.add(maxSub);
        for (int i = 1; i < len; i++) {
            String leftPalindrome = getTheTwoHalvesTheLongestEqual(s.substring(0, len - i), len - i);
            String rightPalindrome = getTheTwoHalvesTheLongestEqual(s.substring(i), len - i);
            subList.add(leftPalindrome);
            subList.add(rightPalindrome);
        }
        return subList.stream().max(Comparator.comparingInt(String::length)).orElse("");
    }

    private String getTheTwoHalvesTheLongestEqual(String s, int totalLen) {
        int oddEvenFlag = totalLen & 1;
        int centerIndex = totalLen / 2 + oddEvenFlag - 1;

        int halfLong = totalLen / 2;
        int start = centerIndex, end = centerIndex;
        for (int i = 1; i <= halfLong; i++) {
            if (s.charAt(halfLong - i) != s.charAt(centerIndex + i)) {
                break;
            }
            start = halfLong - i;
            end = centerIndex + i;
        }

        if (start == end) {
            return leftRightFindCenterChar(s, centerIndex, totalLen);
        }

        if (start == 0) {
            return s;
        }

        return s.substring(start, end + 1);
    }

    private String leftRightFindCenterChar(String s, int centerIndex, int totalLen) {
        int start = centerIndex;
        int end = centerIndex;
        for (int i = centerIndex - 1; i >= 0; i--) {
            if (s.charAt(i) != s.charAt(centerIndex)) {
                break;
            }
            start--;
        }
        if (start != centerIndex) {
            return s.substring(start, centerIndex + 1);
        }
        for (int i = centerIndex + 1; i < totalLen; i++) {
            if (s.charAt(i) != s.charAt(centerIndex)) {
                break;
            }
            end++;
        }
        if (end != centerIndex) {
            return s.substring(centerIndex, end + 1);
        }
        return s.substring(centerIndex, centerIndex + 1);
    }

}

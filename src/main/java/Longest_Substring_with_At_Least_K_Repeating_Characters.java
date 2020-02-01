/**
 * LeetCode-395
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 * hard for me
 */
public class Longest_Substring_with_At_Least_K_Repeating_Characters {
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if (len == 0 || k > len) {
            return 0;
        }
        if (k < 2)
            return len;

        return count(s.toCharArray(), k, 0, len - 1);
    }

    public int count(char[] chars, int k, int p1, int p2) {
        if (p2 - p1 + 1 < k)
            return 0;

        int[] times = new int[26];

        // 统计出现频次
        for (int i = p1; i <= p2; i++) {
            times[chars[i] - 'a']++;
        }

        // 如果该字符出现频次小于k，则不可能出现在结果子串中
        // 分别排除，然后挪动两个指针
        while (p2 - p1 + 1 >= k && times[chars[p1] - 'a'] < k) {
            ++p1;
        }
        while (p2 - p1 + 1 >= k && times[chars[p2] - 'a'] < k) {
            --p2;
        }

        if (p2 - p1 + 1 < k)
            return 0;
        // 得到临时子串，再递归处理
        for (int i = p1; i <= p2; ++i) {
            // 如果第i个不符合要求，切分成左右两段分别递归求得
            if (times[chars[i] - 'a'] < k) {
                return Math.max(count(chars, k, p1, i - 1), count(chars, k, i + 1, p2));
            }
        }
        return p2 - p1 + 1;

    }
}

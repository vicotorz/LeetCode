import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode-331
 * https://leetcode.com/problems/remove-invalid-parentheses/
 *
 * Hard for me
 */
public class Remove_Invalid_Parentheses {
    // https://blog.csdn.net/chaochen1407/article/details/86075846
    // 返回所有可能的结果
    public List<String> removeInvalidParentheses(String s) {
        int leftBra_ToRemove = 0;
        int rightBra_ToRemove = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                leftBra_ToRemove++;
            } else if (ch == ')') {
                if (leftBra_ToRemove > 0) {
                    leftBra_ToRemove--;
                } else {
                    rightBra_ToRemove++;
                }
            }
        }

        // 防止重复
        Set<String> resultSet = new HashSet();
        doDFS(resultSet, new StringBuffer(), s, leftBra_ToRemove, rightBra_ToRemove, 0, 0);

        return new ArrayList<String>(resultSet);
    }

    // open用来控制是否是合理括号，左括号+1，右括号-1，如果小于0，不合法，返回
    private static void doDFS(Set<String> resultSet, StringBuffer sb, String s, int leftToRem, int rightToRem, int open,
                              int curPos) {

        if (curPos == s.length() && leftToRem == 0 && rightToRem == 0 && open == 0) {
            resultSet.add(sb.toString());
        }

        if (leftToRem < 0 || rightToRem < 0 || curPos >= s.length() || open < 0) {
            return;
        }

        int curLen = sb.length();
        char ch = s.charAt(curPos);

        if (ch == '(') {
            doDFS(resultSet, sb, s, leftToRem - 1, rightToRem, open, curPos + 1);// 删掉（
            doDFS(resultSet, sb.append(ch), s, leftToRem, rightToRem, open + 1, curPos + 1);// 不删掉（
        } else if (ch == ')') {
            doDFS(resultSet, sb, s, leftToRem, rightToRem - 1, open, curPos + 1);// 删掉
            doDFS(resultSet, sb.append(ch), s, leftToRem, rightToRem, open - 1, curPos + 1);// 不删掉
        } else {
            doDFS(resultSet, sb.append(ch), s, leftToRem, rightToRem, open, curPos + 1);
        }

        sb.setLength(curLen);

    }
}

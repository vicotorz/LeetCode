/**
 * leetcode-6
 */

public class ZigZag_Conversion {

    public String convert(String s, int numRows) {
        // 找规律：2(numRows-n+1)-3 ====> 2(numRows -行数) -1
        // 正数第n行，倒数numRows-n+1行
        // 一次正数，一次倒数

        if (s == null || s.isEmpty() || numRows <= 0) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        int length = s.length();

        boolean isPositiveSequence = true;

        int currentRowNumber = -1;

        StringBuffer result = new StringBuffer();

        // 组合每行结果信息
        for (int i = 1; i <= numRows; i++) {

            currentRowNumber = i;

            int curStrLoc = currentRowNumber - 1;
            isPositiveSequence = true;

            while (curStrLoc < length) {

                // System.out.println("当前行-----" + currentRowNumber + " 当前位置---" + curStrLoc);
                result.append(s.charAt(curStrLoc));
                // System.out.println(result.toString());

                if (currentRowNumber == numRows) {
                    currentRowNumber = numRows - i + 1;
                }
                // System.out.println("从" + curStrLoc + "跨越" + (2 * (numRows - currentRowNumber)
                // - 1) + "个字符");
                curStrLoc = curStrLoc + 2 * (numRows - currentRowNumber);

                if (isPositiveSequence && i > 1 && i < numRows) {
                    isPositiveSequence = false;
                    currentRowNumber = numRows - i + 1;
                } else if (!isPositiveSequence && i > 1 && i < numRows) {
                    isPositiveSequence = true;
                    currentRowNumber = i;
                }

                // System.out.println("curStrLoc---"+curStrLoc);

            }
        }

        return result.toString();
    }
}

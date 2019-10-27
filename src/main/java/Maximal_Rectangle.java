/**
 * LeetCode-85
 * 这个题需要在leetcode-84启发下做出
 */
public class Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int maxRectangle = 0;
        int[] base = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    base[j] = 0;
                } else {
                    base[j] += Integer.valueOf(String.valueOf(matrix[i][j]));
                }
            }
            maxRectangle = Math.max(maxRectangle, largestRectangleArea(base));
        }
        return maxRectangle;
    }


    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int maxHistorgram = 0;

        // 以当前节点为中心，前后遍历，找到左、右最后一个比当前值大的位置，并计算面积
        for (int i = 0; i < heights.length; i++) {
            int leftWitdth = 0;
            // 向左遍历
            for (int left = i - 1; left >= 0; left--) {
                if (heights[i] > heights[left]) {
                    break;
                }
                leftWitdth++;
            }

            int rightWitdth = 0;
            // 向右遍历
            for (int right = i + 1; right < heights.length; right++) {
                if (heights[i] > heights[right]) {
                    break;
                }
                rightWitdth++;
            }

            maxHistorgram = Math.max(maxHistorgram, (leftWitdth + rightWitdth + 1) * heights[i]);
        }
        return maxHistorgram;
    }
}

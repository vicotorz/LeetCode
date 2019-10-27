/**
 * LeetCode-87
 */
public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0) {
            return 0;
        }

        int maxHistorgram = 0;

        //以当前节点为中心，前后遍历，找到左、右最后一个比当前值大的位置，并计算面积
        for(int i=0;i<heights.length;i++) {
            int leftWitdth=0;
            //向左遍历
            for(int left=i-1;left>=0;left--) {
                if(heights[i]>heights[left]) {
                    break;
                }
                leftWitdth++;
            }

            int rightWitdth=0;
            //向右遍历
            for(int right= i+1;right<heights.length;right++) {
                if(heights[i]>heights[right]) {
                    break;
                }
                rightWitdth++;
            }

            maxHistorgram = Math.max(maxHistorgram, (leftWitdth+rightWitdth+1)*heights[i]);
        }
        return maxHistorgram;
    }
}

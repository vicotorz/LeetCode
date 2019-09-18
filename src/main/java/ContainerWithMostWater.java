/**
 * LeeCode-11
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        //从左依次遍历i，，从右依次遍历j，找到第一个height[i]<=height[j]的位置
        int maxArea=0;
        for(int i=0;i<height.length;i++) {
            for(int j=height.length-1;j>=0;j--) {
                if(height[j]>=height[i]) {
                    //System.out.println(i+"--"+j+"---"+((j-i)*height[i]));
                    maxArea = Math.max(maxArea, (j-i)*height[i]);
                    break;
                }
            }
        }
        //从右依次遍历i，，从左依次遍历j，找到第一个height[i]>=height[j]的位置
        for(int i=height.length-1;i>=0;i--) {
            for(int j=0;j<height.length;j++) {
                if(height[j]>=height[i]) {
                    //System.out.println(i+"--"+j+"---"+((i-j)*height[i]));
                    maxArea = Math.max(maxArea, (i-j)*height[i]);
                    break;
                }
            }
        }
        return maxArea;
    }
}

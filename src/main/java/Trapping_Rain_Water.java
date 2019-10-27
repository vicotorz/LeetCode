/**
 * Created by dell on 2019/10/27.
 */
public class Trapping_Rain_Water {
    public int trap(int[] height) {
        int totalWater = 0;
        int[] tmpHightLeft = new int[height.length];
        int[] tmpHightRight = new int[height.length];
        // 从左向右：每一个数向后比
        for (int i = 0; i < height.length - 2; i++) {
            int tmpH = height[i];
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] >= tmpH) {
                    break;
                } else if (height[j] < tmpH) {
                    tmpHightLeft[j] = (tmpH - height[j]) > tmpHightLeft[j] ? (tmpH - height[j]) : tmpHightLeft[j];
                }

            }
        }
        // 从右向左：每一个数向前比
        for (int i = height.length - 1; i > 0; i--) {
            int tmpH = height[i];
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] >= tmpH) {
                    break;
                } else if (height[j] < tmpH) {
                    tmpHightRight[j] = (tmpH - height[j]) > tmpHightRight[j] ? (tmpH - height[j]) : tmpHightRight[j];
                }

            }
        }

        for (int i = 0; i < tmpHightLeft.length; i++) {
            totalWater += (tmpHightLeft[i] > tmpHightRight[i] ? tmpHightRight[i] : tmpHightLeft[i]);
        }
        return totalWater;
    }
}

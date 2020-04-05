
/**
 * leetcode-1232
 * */
public class Check_IfItIs_a_Straight_Line {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length <= 2) {
            return true;
        }

        boolean flag = true;

        float k = ((float) (coordinates[0][1] - coordinates[1][1])) / ((float) (coordinates[0][0] - coordinates[1][0]));
        // System.out.println(k);
        for (int i = 1; i < coordinates.length; i++) {
            for (int j = 1; j < coordinates[0].length; j++) {

                float k_tmp = ((float) (coordinates[i][1] - coordinates[i - 1][1]))
                        / ((float) (coordinates[i][0] - coordinates[i - 1][0]));
                // System.out.println(k_tmp + "---" + k);
                if (k_tmp != k) {
                    flag = false;
                    return false;
                }
            }
        }

        return flag;
    }
}

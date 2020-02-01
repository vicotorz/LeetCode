import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode-118
 */
public class Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList = new ArrayList();

        List<Integer> preList = null;
        for(int i=1;i<=numRows;i++) {
            List<Integer> tmpRes = new ArrayList();
            for(int n=1;n<=i;n++) {
                if(n==1||n==i) {
                    tmpRes.add(1);
                }else if(n==2||n==i-1) {
                    tmpRes.add(i-1);
                }else {
                    int curRes = (int)preList.get(n-2)
                            +(int)preList.get(n-1);
                    tmpRes.add(curRes);
                }
            }
            preList = tmpRes;
            resList.add(tmpRes);
        }
        return resList;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode-1122
 * */
public class Relative_Sort_Array {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //arr1 按照 arr2 的方式排列，其他元素在arr1中升序排列
        HashMap<Integer,Integer> map = new HashMap();

        //统计arr1中的频率
        for(int i=0;i<arr1.length;i++) {
            if(!map.containsKey(arr1[i])) {
                map.put(arr1[i], 1);
            }else {
                map.put(arr1[i], map.get(arr1[i])+1);
            }
        }


        int loc = 0;
        for(int j=0;j<arr2.length;j++) {
            int frequency = map.get(arr2[j]);

            for(int h=0;h<frequency;h++) {
                arr1[loc] = arr2[j];
                loc++;
            }
            map.put(arr2[j], 0);
        }

        //剩下的排序
        ArrayList<Integer> list = new ArrayList();

        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if(entry.getValue()!=0) {

                for(int k=entry.getValue();k>=1;k--) {
                    //System.out.println("添加+++"+entry.getKey());
                    list.add(entry.getKey());
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.toString());

        int t=0;
        for(; loc < arr1.length;loc++) {
            //System.out.println(loc+"---->"+list.get(t));
            arr1[loc] = list.get(t);
            t++;
        }

        return arr1;
    }
}

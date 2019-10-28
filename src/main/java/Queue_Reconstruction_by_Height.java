import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode-406
 */
public class Queue_Reconstruction_by_Height {
    public int[][] reconstructQueue(int[][] people) {
        //按照身高h降序，人数k升序排列，然后只需要依次将每个人插在k的位置上即可。也就是除了排序以外，只需要一次遍历。
        //思想也很容易理解，对于相同身高的人，人数大的必定在人数小的人的后面，且插入到位置k时，前面比他高（包括同身高）的人数等于k个。而k值相同时，会将身高高的人“挤”到后面去，同样满足其前面身高大于该人的人数为k个。
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            }
        });
        List<int[]> list = new LinkedList();
        for (int[] ppl : people) {
            list.add(ppl[1], ppl);
        }
        return list.toArray(new int[people.length][]);
    }
}

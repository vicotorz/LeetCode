import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode-1302
 * 层次遍历
 * */
public class Deepest_Leaves_Sum {
    public int deepestLeavesSum(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int leafSum = 0;

        leafSum = getLeafSum(root);

        return leafSum;
    }


    public static int getLeafSum(TreeNode root) {
        //层次遍历
        Queue<TreeNode> queue =new LinkedList<TreeNode>();

        queue.add(root);

        int size = queue.size();
        int leafSum = 0;

        TreeNode tmpNode =null;


        while(!queue.isEmpty()) {
            leafSum = 0;
            size = queue.size();

            while(size!=0) {
                tmpNode = queue.poll();
                leafSum = leafSum + tmpNode.val;

                if(tmpNode.left!=null) {
                    queue.add(tmpNode.left);
                }

                if(tmpNode.right!=null) {
                    queue.add(tmpNode.right);
                }

                size--;
            }
        }
        return leafSum;
    }
}

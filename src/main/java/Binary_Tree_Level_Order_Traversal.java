import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LeetCode-102
 */
public class Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        Queue<TreeNode> Queue1 = new LinkedBlockingQueue();
        Queue<TreeNode> Queue2 = new LinkedBlockingQueue();
        Queue1.add(root);
        boolean isQueue1 = true;// 左右控制
        List<List<Integer>> resList = new ArrayList();

        while (!Queue1.isEmpty() || !Queue2.isEmpty()) {
            List<Integer> tmpList = new ArrayList();
            // 构建结果
            if (isQueue1) {
                while (!Queue1.isEmpty()) {
                    TreeNode treeNode = Queue1.poll();
                    tmpList.add(treeNode.val);
                    if (treeNode.left != null) {
                        Queue2.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        Queue2.add(treeNode.right);
                    }
                }
            } else {
                while (!Queue2.isEmpty()) {
                    TreeNode treeNode = Queue2.poll();
                    tmpList.add(treeNode.val);
                    if (treeNode.left != null) {
                        Queue1.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        Queue1.add(treeNode.right);
                    }
                }
            }
            isQueue1 = isQueue1 ^ true;
            if (!tmpList.isEmpty()) {
                resList.add(tmpList);
            }
        }
        return resList;
    }
}

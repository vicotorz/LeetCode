import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LeetCode-103
 */
public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        // 怎么判断第几层
        // 利用两个Queue进行左右转换
        Queue<TreeNode> LeftToRightQueue = new LinkedBlockingQueue();// left先，right后
        Queue<TreeNode> RightToLeftQueue = new LinkedBlockingQueue();// right先，left后

        // 每一次从Queue弹出，都将TreeNode放到Stack中，从Stack中弹出用以确认下一个Queue放哪些元素
        Stack<TreeNode> stack = new Stack();

        LeftToRightQueue.add(root);
        List<List<Integer>> resList = new ArrayList();
        boolean isLeftToRight = true;// 左右控制
        while (!LeftToRightQueue.isEmpty() || !RightToLeftQueue.isEmpty()) {
            List<Integer> tmpList = new ArrayList();
            // 构建结果
            if (isLeftToRight) {
                while (!LeftToRightQueue.isEmpty()) {
                    TreeNode treeNode = LeftToRightQueue.poll();
                    tmpList.add(treeNode.val);
                    stack.add(treeNode);

                }
            } else {
                while (!RightToLeftQueue.isEmpty()) {
                    TreeNode treeNode = RightToLeftQueue.poll();
                    tmpList.add(treeNode.val);
                    stack.add(treeNode);
                }
            }

            // System.out.println(LeftToRightQueue.size()+"---"+RightToLeftQueue.size()+"---"+stack.size()+"---"+isLeftToRight);

            // 清空stack，构建下一行
            while (!stack.isEmpty()) {
                TreeNode treeNode = stack.pop();
                // System.out.println(treeNode.val);
                if (isLeftToRight) {
                    if(treeNode.right!=null) {
                        RightToLeftQueue.add(treeNode.right);
                    }
                    if(treeNode.left!=null) {
                        RightToLeftQueue.add(treeNode.left);
                    }
                } else {
                    if(treeNode.left!=null) {
                        LeftToRightQueue.add(treeNode.left);
                    }
                    if(treeNode.right!=null) {
                        LeftToRightQueue.add(treeNode.right);
                    }
                }
            }
            isLeftToRight = isLeftToRight ^ true;
            if (!tmpList.isEmpty()) {
                resList.add(tmpList);
            }
        }
        return resList;
    }
}

/**
 * LeetCode-124
 * hard for me
 */
public class Binary_Tree_Maximum_Path_Sum {
    public int maxPathSum(TreeNode root) {
        // 路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
        int[] res = new int[1];//主要是为了传引用过去
        res[0] = Integer.MIN_VALUE;
        calPath(root,res);
        return res[0];
    }

    // 第一种是左子树的路径加上当前节点
    // 第二种是右子树的路径加上当前节点
    // 第三种是左右子树的路径加上当前节点
    // 第四种是只有自己的路径
    public int calPath(TreeNode root,int[] res) {
        if (root == null) {
            return 0;
        }
        int left = calPath(root.left,res);// 加就加正数，要么就不加
        int right = calPath(root.right,res);
        // 连接父节点的最大路径是一、二、四这三种情况的最大值
        int currSum = Math.max(Math.max(left + root.val, right + root.val), root.val);
        // 当前节点的最大路径是一、二、三、四这四种情况的最大值
        res[0] = Math.max(res[0], Math.max(currSum, left + right + root.val));
        return currSum;// 以当前节点为终点的path和
    }
}

/**
 * LeetCode-104
 */
public class Max_Depth_Tree {
    public int maxDepth(TreeNode root) {
        if(root ==null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right != null) {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        } else if (root.left != null) {
            return 1 + maxDepth(root.left);
        } else if (root.right != null) {
            return 1 + maxDepth(root.right);
        }
        return 0;
    }
}

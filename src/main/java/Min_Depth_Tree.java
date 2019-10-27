/**
 * LeetCode-111
 */
public class Min_Depth_Tree {
    public int minDepth(TreeNode root) {
        int height = 0;
        if (root != null) {
            if (root.left == null && root.right != null) {
                return 1 + minDepth(root.right);
            }
            if (root.right == null && root.left != null) {
                return 1 + minDepth(root.left);
            }
            height = 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        return height;
    }
}

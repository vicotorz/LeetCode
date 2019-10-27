/**
 * LeetCode-226
 */
public class Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if (root==null ||( root.left == null && root.right == null )) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(root.right);
        invertTree(root.left);

        return root;
    }
}

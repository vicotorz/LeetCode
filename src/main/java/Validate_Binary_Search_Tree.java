/**
 * LeetCode-98
 */
public class Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return checkNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkNode(TreeNode node, long min, long max) {
        if (node == null){
            return true;
        }
        if(node.val > min && node.val < max){
            return (checkNode(node.left, min, node.val) && checkNode(node.right, node.val, max));
        } else {
            return false;
        }
    }
}

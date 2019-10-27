import java.util.*;

/**
 * LeetCode-236
 * hard for me
 */
public class Lowest_Common_Ancestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //Stack用于遍历
        Deque<TreeNode> stack = new ArrayDeque();

        //HashMap用于记录当前节点的父节点
        HashMap<TreeNode,TreeNode> node_parentMap = new HashMap();

        node_parentMap.put(root, null);
        stack.push(root);//遍历root

        //如果还没有访问到p或q
        while(!node_parentMap.containsKey(p)||!node_parentMap.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                node_parentMap.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                node_parentMap.put(node.right, node);
                stack.push(node.right);
            }
        }
        //这里p / q 已经被找到
        //遍历p的所有父节点
        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<TreeNode>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = node_parentMap.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q)) {
            q = node_parentMap.get(q);
        }
        return q;
    }
}

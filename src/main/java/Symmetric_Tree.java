import java.util.ArrayList;

/**
 * LeetCode-101
 */
public class Symmetric_Tree {
    ArrayList<Integer> leftList = new ArrayList();
    ArrayList<Integer> rightList = new ArrayList();

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        // 从左广度遍历，和从右广度遍历值相同
        // 从左的深度遍历，和从右的深度遍历相同
        boolean flag = true;
        depthSearhLeft(root);
        depthSearhRight(root);
        //System.out.println(leftList.size()+"---"+rightList.size());
        if (leftList.size() != rightList.size()) {
            return false;
        }

        for (int i = 0; i < leftList.size(); i++) {
            //System.out.println(leftList.get(i)+"----"+rightList.get(i));
            if (leftList.get(i) != rightList.get(i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void depthSearhLeft(TreeNode root) {
        if (root == null) {
            leftList.add(-1);
            return;
        }
        leftList.add(root.val);
        depthSearhLeft(root.left);
        depthSearhLeft(root.right);
    }

    public void depthSearhRight(TreeNode root) {
        if (root == null) {
            rightList.add(-1);
            return;
        }
        rightList.add(root.val);
        depthSearhRight(root.right);
        depthSearhRight(root.left);
    }
}

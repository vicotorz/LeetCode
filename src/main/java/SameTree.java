/**
 * LeetCode-100
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null && q!=null)||(p!=null && q==null)){
            return false;
        }
        if(p==null||q==null){
            return true;
        }
        return (p.val==q.val?true:false) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

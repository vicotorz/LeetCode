/**
 * LeetCode-96
 */
public class Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        //左子树的节点的个数为i-1，（为1,...i-1）,右子树的个数为n-i（为，i+1,...n）。
        //对一个根来说，唯一二叉树的个数为左子树结点的个数乘以右子树的个数。而根节点可以从1到n 中选择。
        if(n<=1) {
            return 1;
        }
        int sum=0;

        for(int i=1;i<=n;i++) {
            sum += numTrees(i-1)*numTrees(n-i);
        }
        return sum;
    }
}

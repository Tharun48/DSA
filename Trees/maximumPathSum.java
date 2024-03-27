import java.util.*;
class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
        TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
             this.left = left;
            this.right = right;
        }
}
class Solution {
    int sum=Integer.MIN_VALUE;
    private int getMaximumPathSum(TreeNode root) {
        if(root==null)
            return 0;
        int leftSum = Math.max(0,getMaximumPathSum(root.left));
        int rightSum =Math.max(0,getMaximumPathSum(root.right));
        sum = Math.max(sum,leftSum+rightSum+root.val);
        return root.val+Math.max(leftSum,rightSum);
    }
    public int maxPathSum(TreeNode root) {
        getMaximumPathSum(root);
        return sum;
    }
}
//LeetCode 124


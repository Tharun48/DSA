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
    private int func(TreeNode root,int k[]) {
        if(root==null) return Integer.MAX_VALUE;
        int leftVal = func(root.left,k);
        if(leftVal!=Integer.MAX_VALUE) return leftVal;
        k[0]--;
        if(k[0]==0) return root.val;
        return func(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        return func(root,new int[]{k});
    }
}
//Leetcode 230
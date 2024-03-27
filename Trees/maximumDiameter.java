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
    int ans=Integer.MIN_VALUE;
    private int func(TreeNode root) {
        if(root==null) return 0;
        int left = func(root.left);
        int right = func(root.right);
        ans = Math.max(ans,left+right);
        return 1+Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int val = func(root);
        return ans;
    }
}
//Using single Stack


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
    private int getDepth(TreeNode root) {
        if(root==null)
            return 0;
        return 1 + Math.max( getDepth(root.left),getDepth(root.right));
    } 
    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }
}
//Using single Stack


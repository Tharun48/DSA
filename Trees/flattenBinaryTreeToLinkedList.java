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
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur!=null) {
            if(cur.left!=null) {
                TreeNode prev = cur.left;
                TreeNode connect = cur.left;
                while(prev.right!=null) {
                    prev=prev.right;
                }
                prev.right=cur.right;
                cur.right=connect;
                cur.left=null;
                cur=cur.right;
            }
            else{
                cur=cur.right;
            }
        }
    }
}
//Leetcode 114
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
    private TreeNode getLeftLargerChild(TreeNode cur) {
        TreeNode prev = cur;
        while(cur!=null) {
            prev=cur;
            cur = cur.right;
        }
        return prev;
    }
    private TreeNode helper(TreeNode cur) {
        if(cur.left==null) {
            return cur.right;
        }
        else if(cur.right==null) {
            return cur.left;
        }
        TreeNode leftRoot = cur.left;
        TreeNode rightRoot = cur.right;
        TreeNode leftSmallestChild = getLeftLargerChild(leftRoot);
        leftSmallestChild.right = rightRoot;
        return leftRoot;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val==key) {
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            TreeNode leftLargerChild = getLeftLargerChild(root.left);
            TreeNode rightNode = root.right;
            leftLargerChild.right = rightNode;
            return root.left;
        }
        TreeNode cur = root;
        while(cur!=null) {
            if(cur.val>key) {
                if(cur.left!=null && cur.left.val==key) {
                    cur.left = helper(cur.left);
                    break;
                }
                else {
                    cur = cur.left;
                }
            }
            else {
                if(cur.right!=null && cur.right.val==key) {
                    cur.right = helper(cur.right);
                    break;
                }
                else {
                    cur = cur.right;
                }
            }
        }
        return root;
    }
}
//Leetcode 450
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
    private TreeNode BinarySearchOnLCA(TreeNode root,TreeNode p,TreeNode q) {
        if(root==null || root==p || root==q)
            return root;
        if(root.val>p.val && root.val<q.val)
            return root;
        if(root.val>p.val && root.val>q.val) {
            return BinarySearchOnLCA(root.left,p,q);
        }
        else {
            return BinarySearchOnLCA(root.right,p,q);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val) {
            TreeNode temp = p;
            p=q;
            q=temp;
        }
        return BinarySearchOnLCA(root,p,q);
    }
}
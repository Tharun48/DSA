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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        TreeNode cur = root;

        while(cur!=null) {
            // pre.add(cur.val);
            if(cur.left==null) {
                pre.add(cur.val);
                cur=cur.right;
            }
            else{
                TreeNode temp = cur.left;
                while(temp.right!=null && temp.right!=cur) {
                    temp=temp.right;
                }
                if(temp.right==null) {
                    pre.add(cur.val);
                    temp.right=cur;
                    cur=cur.left;
                }
                else{
                    temp.right=null;
                    cur = cur.right;
                }
            }
        }
        return pre;
    }
}
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
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private TreeNode prev;
    private void inorder(TreeNode root) {
        if(root==null)
            return ;
        inorder(root.left);
        if(prev==null) {
            prev=root;
        }
        else {
            if(prev.val>root.val) {
                if(first==null) {
                    first=prev;
                    middle=root;
                }
                else{
                    last=root;
                }
            }
            else {
                prev=root;
            }
        }
        
        
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first=middle=last=null;
        prev = null;
        inorder(root);
        if(last==null) {
            int val = middle.val;
            middle.val=first.val;
            first.val=val;
        }
        else{
            int val = first.val;
            first.val=last.val;
            last.val=val;
        }
    }
}
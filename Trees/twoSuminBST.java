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
    private void reverseInorder(TreeNode root,Stack<TreeNode> stack) {
        while(root!=null) {
            stack.push(root);
            root=root.right;
        }
    }
    private void inorder(TreeNode root,Stack<TreeNode> stack) {
        while(root!=null) {
            stack.push(root);
            root=root.left;
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        TreeNode cur1 = root;
        TreeNode cur2 = root;
        inorder(cur1,stack1);
        reverseInorder(cur2,stack2);

        while(!stack1.isEmpty() || !stack2.isEmpty() ) {
            TreeNode left = stack1.peek();
            TreeNode right = stack2.peek();
            if(left==right)
                break;

            if((left.val + right.val) == k) 
                return true;
            
            if((left.val+right.val) < k) {
                TreeNode cur = stack1.pop();
                cur = cur.right;
                inorder(cur,stack1);
            }
            else {
                TreeNode cur = stack2.pop();
                cur = cur.left;
                reverseInorder(cur,stack2);
            }
        }
        return false;
    }
}
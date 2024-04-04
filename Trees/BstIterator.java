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
class BSTIterator {
    Stack<TreeNode> stack;
    private void func(Stack<TreeNode> stack,TreeNode root) {
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
    }
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        func(stack,root);
    }
    
    public int next() {
        TreeNode top = stack.pop();
        if(top.right!=null) {
            func(stack,top.right);
        }
        return top.val;
    }
    
    public boolean hasNext() {
        if(!stack.isEmpty()) 
            return false;
        return true;
    }
}
//Leetcode 173
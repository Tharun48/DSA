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
    public List<Integer> postOrderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list  = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return list;
    }
}
//Using single Stack

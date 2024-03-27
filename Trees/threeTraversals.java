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
class Pair{
    int n;
    TreeNode node;
    Pair(int n,TreeNode node){
        this.n=n;
        this.node=node;

    }
}
class Solution {
    public void threeTraversals(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(1,root));
        while(!stack.isEmpty()) {
            Pair top = stack.pop();
            int num = top.n + 1;
            TreeNode cur = top.node;
            if(num==1) {
                preOrder.add(cur.val);
                stack.push(new Pair(num+1, cur));
                if(cur.left!=null) {
                    stack.push(new Pair(1, cur.left));
                }
            }
            else if(num==2){
                inOrder.add(cur.val);
                stack.push(new Pair(num+1, cur));
                if(cur.left!=null) {
                    stack.push(new Pair(1, cur.right));
                }
            }
            else{
                postOrder.add(cur.val);
            }
        }
        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
    }
}
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack();
        while(i<n) {
            if(stack.isEmpty() || stack.peek()!=popped[j]) {
                stack.push(pushed[i]);
                i++;
            }
            while(!stack.isEmpty() && stack.peek()==popped[j]) {
                stack.pop();
                j++;
            } 
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}

class Main {
      public static void main(String args[]) {
            Solution s = new Solution();
            int pushed[] = {1,2,3,4,5};
            int poped[] = {4,5,3,2,1};
            System.out.println(s.validateStackSequences(pushed,poped));
      }
}

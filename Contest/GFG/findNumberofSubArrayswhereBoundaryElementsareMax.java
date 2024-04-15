import java.util.*;
class Solution {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length;
        long ans=0;
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && nums[i]>stack.peek()) {
                map.put(stack.peek(),map.getOrDefault(stack.peek(),0)-1);
                stack.pop();
            }
            if(stack.isEmpty()) {
                ans++;
            }
            else{
                if(stack.peek()==nums[i]) {
                    ans += map.get(nums[i])+1;
                }
                else{
                    ans++;
                }
            }
            stack.push(nums[i]);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return ans;
    }
}
//lc 3133
import java.util.*;
class Solution {
    private int getMax(int nums[]) {
        int max = Integer.MIN_VALUE;
        for(int n : nums )
            max = Math.max(max,n);
        return max;
    }
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans=0;
        int cnt=0;
        int max=getMax(nums);
        int start=0;
        int end=0;
        while(end<n) {
            if(nums[end]==max)
                cnt++;
            if(cnt==k) {
                ans += n-end;
                while(cnt>=k) {
                    if(nums[start]==max)
                        cnt--;
                    if(cnt>=k) {
                        ans += n-end;
                    }
                    start++;
                }
            }
            end++;
        }
        return ans;
    }
}
//LeetCode 2962


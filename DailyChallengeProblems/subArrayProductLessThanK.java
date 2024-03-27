class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int cnt=0;
        int start=0;
        int end=0;
        int prod=1;
        while(end<n) {
            prod = prod*nums[end];
            if(prod<k) {
                cnt += (end-start+1);
            }
            else{
                while(start<end && prod>=k) {
                    prod=prod/nums[start];
                    start++;
                }
                if(prod<k) {
                    cnt += (end-start+1);
                }
            }
            end++;
        }
        return cnt;
    }
}

class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        long ans=Long.MAX_VALUE;
        TreeSet<Integer> minSet = new TreeSet<>((a,b)->nums[a]==nums[b] ? a-b : nums[a]-nums[b]);
        TreeSet<Integer> remSet = new TreeSet<>((a,b)->nums[a]==nums[b] ? a-b : nums[a]-nums[b]);
        int n = nums.length;
        long curSum=nums[0];
        for(int i=1;i<=dist+1;i++) {
            minSet.add(i);
            curSum += nums[i];
        }
        k--;
        while(minSet.size()>k) {
            int lastIndex = minSet.pollLast();
            remSet.add(lastIndex);
            minSet.remove(lastIndex);
            curSum -= nums[lastIndex];
        }
        
        ans = Math.min(ans,curSum);
        int start=1;
        int end=dist+2;
        while(end<n) {
            /******* adding new element ********/
            remSet.add(end);
            
            if(minSet.contains(start)) {
                minSet.remove(start);
                curSum -= nums[start];
                int firstMinIndex = remSet.pollFirst();
                minSet.add(firstMinIndex);
                curSum += nums[firstMinIndex];
            }
            else {
                remSet.remove(start);
                int minSetLastIndex = minSet.last();
                int remSetFirstIndex = remSet.first();
                if(nums[remSetFirstIndex]<nums[minSetLastIndex]) {
                    curSum -= nums[minSetLastIndex];
                    minSet.remove(minSetLastIndex);
                    remSet.add(minSetLastIndex);
                    curSum += nums[remSetFirstIndex];
                    remSet.remove(remSetFirstIndex);
                    minSet.add(remSetFirstIndex);
                }
            }
            ans = Math.min(ans,curSum);
            start++;
            end++;
        }
        return ans;
    }
}
//LC Weekly Biweekly 122 contest (3013)
//Sliding window technique
//We need to keep track of first k smaller elements
//add the new element Index to 2nd set
//if window start contains in 1st set remove and add the smallest index from 2nd set
//else remove start from 2nd set and :
//i=lastMaxElement from 1st set
//j=firstMinElement from 2nd set
// if nums[i]>nums[j] swap(i,j) i.e add i to 2nd set and j to first set
//Time complexity - O(N) * log(N) 
// log(N) for pollFirst() and pollLast().

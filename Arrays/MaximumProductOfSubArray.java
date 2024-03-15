class Solution{
    //Kadane's Algorithm
    long maxSubarraySum(int arr[], int n){
        long maxi = Long.MIN_VALUE;
        long sum = 0;
        for(int i=0;i<n;i++) {
            int num = arr[i];
            sum += num;
            if(sum<0) {
                maxi = Math.max(maxi,sum);
                sum = 0;
                continue;
            }
            maxi = Math.max(maxi,sum);
        }
        return maxi;
    }
}
//Tc -> O(N)

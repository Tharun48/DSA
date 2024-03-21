class Solution {
    public static int maxScoreSubseq(int n, int[] arr) {
        int sum=Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(arr[i]>=0)
                map.put(arr[i]-i,map.getOrDefault(arr[i]-i,0)+arr[i]);
            sum = Math.max(sum,arr[i]);
        }
        int maxSum=Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> mpp : map.entrySet() ) {
            maxSum = Math.max(maxSum,mpp.getValue());
        }
        return Math.max(maxSum,sum);
    }
}

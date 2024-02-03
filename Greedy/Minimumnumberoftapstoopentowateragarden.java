class Solution {
    public int minTaps(int n, int[] ranges) {
        int maxRanges[] = new int[ranges.length];
        for(int i=0;i<=n;i++) {
            int low = Math.max(0,i-ranges[i]);
            int high = Math.min(n,i+ranges[i]);
            maxRanges[low]=Math.max(maxRanges[low],high);
        }
        //System.out.println(Arrays.toString(maxRanges));
        int ans=0;
        int farthest=0;
        int end=0;
        // if(farthest==n) return ans;
        for(int i=0;i<ranges.length;) {
            if(end==n) break;
            ans++;
            while(i<=end && i<ranges.length) {
                farthest = Math.max(farthest,maxRanges[i]);
                //System.out.println("end = " + end);
                i++;
            }
            //System.out.println(farthest);
            if(end==farthest) return -1;
            end = farthest;
            //System.out.println("end = " + end);
        }
        return ans;
    }
}

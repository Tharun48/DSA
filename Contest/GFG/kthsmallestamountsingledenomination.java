class Solution {
    private long getGcd(long a,long b) {
        while(a>0 && b>0) {
            if(b>a) {
                long temp=a;
                a=b;
                b=temp;
            }
            a=a%b;
        }
        return a==0 ? b : a;
    }
    private long getLcm(long a,long b) {
        return (a*b)/getGcd(a,b);
    }
    private boolean isPossible(long mid,int coins[],int k) {
        //using subset concept pick all the combinations...
        // System.out.println("mid = " + mid);
        int n = coins.length;
        int m = 1<<n;
        long count=0;
        for(int i=0;i<m;i++) {
            // System.out.println("number** = " + i);
            long lcm = 1;
            int cnt=0;
            for(int j=0;j<n;j++) {
                // System.out.println("j** = " + j);
                if(( i & (1<<j) )!=0) {
                    // System.out.println("bit = " + j);
                    lcm = getLcm(lcm,(long)coins[j]);
                    cnt++;
                }
            }
            // System.out.println("lcm = " + lcm);
            if(cnt==0) continue;
            if(cnt%2==0) {
                count -= (mid)/lcm;
            }
            else{
                count += (mid)/lcm;
            }
        }
        return count>=k;
    }
    public long findKthSmallest(int[] coins, int k) {
        long low=1;
        long high= (long)100000 * (long)10000 * (long)50;
        long ans=0;
        // System.out.println(getLcm(18,24));
        while(low<=high) {
            long mid = (low+high)/2;
            if(isPossible(mid,coins,k)) {
                // System.out.println(mid);
                ans = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
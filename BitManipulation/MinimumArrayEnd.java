class Solution {
    private long func(int n,int x){
        long bits[] = new long[64];
        for(int i=0;i<32;i++) {
            if( ((x) & (1<<i))!=0 ) {
                bits[i]=1;
            }
        }
        // System.out.println("intial = " + Arrays.toString(bits));
        long bitVal = (long)n-1;
        for(int i=0;i<64 && bitVal>0;i++) {
            if(bits[i]==0) {
                long a = bitVal & 1;
                bits[i]=a;
                bitVal=bitVal>>1;
                // System.out.println("change = " + Arrays.toString(bits));
            }
        }
        long ans=0;
        for(int i=0;i<64;i++) {
            if(bits[i]==1) {
            long val = (long)1<<i;
            // System.out.println("val = " + val);
            ans = ans + val;
            }
        }
        // System.out.println("ans = " + ans);
        return ans;
    }
    public long minEnd(int n, int x) {
        return func(n,x);
    }
}

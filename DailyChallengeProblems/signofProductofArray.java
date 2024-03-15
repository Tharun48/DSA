class Solution {
    public int arraySign(int[] nums) {
        int n = 1;
        for(int k : nums ) {
            if(k<0 && n==1)
                n = -1;
            else if(k<0 && n==-1)
                n = 1;
            else if(k>0 && n==1)
                n = 1;
            else if(k>0 && n==-1) {
                n = -1;
            }
            else if(k==0)
                return 0;
        }
        return n;
    }
}

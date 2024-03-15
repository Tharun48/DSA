class Solution {
    public int[] circularGameLosers(int n, int k) {
        if(n==1)
            return new int[]{};
        boolean freq[] = new boolean[n+1];
        freq[1] = true;
        int itr = 1;
        int count = 1;
        int cur = 1;
        while(true) {
            cur = (cur + itr * k)%(n);
            if(!freq[cur]) {
                freq[cur] = true;
                count++;
            }
            else 
                break;
            itr++; 
        }
        int ans[] = new int[n-count];
        int l=0;
        for(int i=0;i<n;i++) {
            if(!freq[i]) {
                if(i==0) {
                    ans[l++] = n;
                }
                else 
                    ans[l++] = i;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}

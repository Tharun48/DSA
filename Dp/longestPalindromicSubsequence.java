class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuffer sbr = new StringBuffer(s);
        String t = sbr.reverse().toString();
        int n = s.length();
        
        /* 
        
        memoization
        
        int dp[][] = new int[n+1][n+1];
        for(int a[] : dp )
            Arrays.fill(a,-1);
        return helper(s,t,n,n,dp);
        
        */
        
        //tabulation
        
        int dp[][] = new int[n+1][n+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(s.charAt(i-1)==t.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }

    int helper(String s,String t,int i,int j,int dp[][]) {
        if(i==0 || j==0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)) {
            return dp[i][j]= 1 + helper(s,t,i-1,j-1,dp);
        }
        return dp[i][j]=Math.max(helper(s,t,i-1,j,dp),helper(s,t,i,j-1,dp));
    }
}

//Tabulation
//Sc -> O(N*N)
//Tc -> O(N*N)

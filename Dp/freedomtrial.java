public class freedomtrial {
    
}
class Solution {
    private int func(int i,String key,String ring,Map<Integer,List<Integer>> map,int ptr,int dp[][]) {
        int n = key.length();
        if(n==i) return 0;
        if(dp[i][ptr]!=-1) return dp[i][ptr];
        int ans=Integer.MAX_VALUE;
        int val = key.charAt(i)-'a';
        for(int ind : map.get(val)) {
            int a = Math.abs(ptr-ind);
            int b = ring.length()-a;
            int c = Math.min(a,b);
            int minimumLength = c + 1 + func(i+1,key,ring,map,ind,dp);
            ans = Math.min(ans,minimumLength);
        }
        return dp[i][ptr]=ans;
    }
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            int c = ring.charAt(i)-'a';
            if(map.containsKey(c)) {
                map.get(c).add(i);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c,list);
            }
        }
        int dp[][] = new int[m+1][n+1];
        for(int a[] : dp ) Arrays.fill(a,-1);
        return func(0,key,ring,map,0,dp);
    }
}
//LC-514
//list can be used in order to improve time complexity
class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int ans = Integer.MIN_VALUE;
        int count = 0;
        //O(N)
        while(end<n) {
            char c = s.charAt(end);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                count++;
            if(end-start+1==k) {
                ans = Math.max(ans,count);
                c = s.charAt(start);
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                    count--;
                start++;
            }
            end++;
        }
        return ans;
    }
}

class Solution {
    private int[] kmp(String s) {
        int lps[] = new int[s.length()];
        lps[0]=0;
        int n = lps.length;
        for(int i=1;i<n;i++) {
            int prevIndex=lps[i-1];
            while(prevIndex>0 && s.charAt(i)!=s.charAt(prevIndex)) {
                prevIndex = lps[prevIndex-1];
            }
            lps[i] = prevIndex + ( (s.charAt(i)==s.charAt(prevIndex)) ? 1 : 0);
        }
        return lps;
    }
    public int minimumTimeToInitialState(String s, int k) {
        int n = s.length();
        String sb = s.substring(0,k);
        int lps[] = kmp(s);
        int maxLength = lps[n-1];
        System.out.println(Arrays.toString(lps));
        while(maxLength>0 && (n-maxLength)%k!=0) {
            maxLength = lps[maxLength-1];
        }
        if(n-maxLength==0) return 1;
        return (n-maxLength)%k==0 ? (n-maxLength)/k : ((n-maxLength)/k)+1;
    }
}

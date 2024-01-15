class Solution {
    private int[] kmp(String s) {
        int n = s.length();
        int lps[] = new int[n];
        lps[0]=0;
        for(int i=1;i<n;i++) {
            int prevIndex=lps[i-1];
            while(prevIndex>0 && s.charAt(i)!=s.charAt(prevIndex)) {
                // System.out.println("i "+ i + " prevIndx = " + prevIndex );
                prevIndex = lps[prevIndex-1];
            }
            lps[i] = prevIndex + ( (s.charAt(i)==s.charAt(prevIndex)) ? 1 : 0);
        }
        return lps;
    }
}


// Tc - O(N)+(M)
// N-length of pattern
// M - length of string
// s - "abc" + "#" + "abcbabcabc"

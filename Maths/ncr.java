class Solution {
    /*
        this ncr will be terminated if the ways of placing is greater than k
        20c10 is greater than 10^6, so the below code will be terminated even before running for 20 times for the largest K value
    */
    /*
        ncr->n!/(n-r)!*(r!)
        ncr=n*n-1*n-2* reduce the n upto r time / 1*2*...r
        ncr=nC(n-r)
    */
    long ncr(int n,int r,int limit){
        if(r>n-r) r=n-r;
        long ways=1;
        for(int i=0;i<r;i++){
            ways*=(n-i);
            ways/=(i+1);
            if(ways>limit) return limit+1;
        }
        return ways;
    }
    int getPermutations(int freq[],int k){
        // System.out.println(Arrays.toString(freq));
        int total=getFreqCount(freq);
        // System.out.println("count = " + total);
        long ways=1;
        // System.out.println();
        for(int i=0;i<26;i++){
            if(freq[i]==0) continue;
            long choices=ncr(total,freq[i],k);
            if(choices>k) return k+1;
            ways*=choices;
            if(ways>k) return k+1;
            total-=freq[i];
            // System.out.println("total = " + total);
        }
        return (int)ways;
    }
    int getFreqCount(int a[]){
        int total=0;
        for(int f : a ) total+=f;
        return total;
    }
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int freq[] = new int[26];
        for(int i=0;i<n/2;i++){
            int v = s.charAt(i)-'a';
            freq[v]++;
        }
        int totalPer=getPermutations(freq,k);
        // System.out.println("totalPer = " + totalPer);
        if(totalPer<k) return "";
        String ans = "";
        for(int i=0;i<n/2;i++){
            for(int c=0;c<26;c++){
                if(freq[c]==0) continue;
                freq[c]--;
                //number of permuations starting with the character j
                int p = getPermutations(freq,k);
                if(p<k){
                    k-=p;
                    freq[c]++;
                }
                else{
                    ans+=(char)('a'+c);
                    break;
                }
            }
        }
        String rev=new StringBuffer(ans).reverse().toString();
        if(n%2==1) ans+=(s.charAt(n/2));
        return ans+rev;
    }
}

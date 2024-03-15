class Solution {
    private List<Integer> kmp(String s,int size) {
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
        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(lps[i]==size) {
                list.add(i-(size*2));
            }
        }
        return list;
    }
    private int getLowerBound(int num,List<Integer> list) {
        int n = list.size();
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high) {
            int mid = (low + high)/2;
            if(list.get(mid)>=num) {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
    }
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int n = s.length();
        String intialString = s;
        s = a + "#" + s;
        List<Integer> listA = kmp(s,a.length());
        s = b + "#" + intialString;
        List<Integer> listB = kmp(s,b.length());
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<listA.size();i++) {
            int num = listA.get(i);
            int lb = getLowerBound(num,listB);
            if(lb!=listB.size()) {
                int val = listB.get(lb);
                if(Math.abs(val-num)<=k) {
                    list.add(listA.get(i));
                    continue;
                }
            }
            if(lb!=0) {
                int val = listB.get(lb-1);
                if(Math.abs(val-num)<=k) {
                    list.add(listA.get(i));
                }
            }
        }
        return list;
    }
}


//KMP
//pattern + "#" + string
// LC - 3008

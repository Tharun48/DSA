class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for(int i=1;i<=n;i++) {
            String s = Integer.toString(i*i);
            if(canbeDone(s,i))
                ans += i*i;
        }
        return ans;
    }
    private static boolean canbeDone(String s, int target) {

        if(target==0 && s=="")
            return true;
        int n = s.length();
        for(int i=0;i<n;i++) {
            String leftString = s.substring(0,i+1);
            String rightString = s.substring(i+1);
            int leftNum = Integer.parseInt(leftString);
            if(canbeDone(rightString,target-leftNum)) {
                return true;
            }
        }
        return false;
    }
}

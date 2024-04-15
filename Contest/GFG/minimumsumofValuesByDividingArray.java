import java.util.*;
class Solution {
    // int intialAnd=(1<<31)-1;
    private int func(int i,int j,int nums[],int and[],int val,HashMap<Integer, Integer>[][] map) {
        int n = nums.length;
        int m = and.length;
        if(i==n) {
            if(j==m-1 && val==and[j]) return nums[i-1];
            else return 10000000;
        }

        if(j>=m) return 10000000;

        if( (val&nums[i])<and[j]) return 10000000;
        
        // String key = i + "|" + j + "|" + val;

        if(map[i][j] != null && map[i][j].get(val)!=null) return map[i][j].get(val);

        int notPick = func(i+1,j,nums,and,val&nums[i],map);
        int take = 10000000;
        if( (val&nums[i])==and[j]) {
            take = nums[i]+func(i+1,j+1,nums,and,~0,map);
        }

        int ans=Math.min(take,notPick);

        if(map[i][j] == null) map[i][j] = new HashMap<>();
        map[i][j].put(val,ans);
        return ans;
    }
    private int getSum(int nums[]) {
        int sum=0;
        for(int ele : nums ) {
            sum += ele;
        }
        return sum;
    }
    public int minimumValueSum(int[] nums, int[] andValues) {
        int n = nums.length;
        int m = andValues.length;
        HashMap<Integer, Integer>[][] map = new HashMap[nums.length][andValues.length];
        int ans = func(0,0,nums,andValues,~0,map);
        return ans==10000000 ? -1 : ans;
    }
}
//lc 3117
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans=0;
        //[index]->{diff,cnt}
        List<Map<Long,Integer>> list = new ArrayList<>();
        for(int i=1;i<n;i++) {
            Map<Long,Integer> map = new HashMap<>();
            for(int j=0;j<i;j++) {
                long dif = (long)nums[i]-(long)nums[j];
                if(j==0) {
                    map.put(dif,1);
                }
                else {
                    Map<Long,Integer> innerMap = list.get(j-1);
                    int a=0;
                    int b=0;
                    if(map.containsKey(dif)) {
                        a = map.get(dif);
                    }
                    if(innerMap.containsKey(dif)) {
                        b = innerMap.get(dif);
                    }
                    if(map.containsKey(dif)) {
                        map.put(dif,a+b+1);
                    }
                    else{
                        map.put(dif,b+1);
                    }
                    ans += b;
                }
            }
            //System.out.println(map);
            list.add(map);
        }
        return ans;
    }
}
//Using Longest Common subsequence

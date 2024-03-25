import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int ele : nums ) {
            // System.out.println(ele);
            if(nums[Math.abs(ele)-1]<0) {
                list.add(Math.abs(ele));
            }
            else{
                nums[Math.abs(ele)-1]=-1*nums[Math.abs(ele)-1];
            }
            System.out.println(Arrays.toString(nums));
        }
        return list;
    }
}
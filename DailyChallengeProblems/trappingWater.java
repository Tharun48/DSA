import java.util.*;
class Solution {
    private int[] getRightLargestElement(int nums[]) {
        int n = nums.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans,n);

        for(int i=0;i<n;i++) {
            int val = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]<val) {
                ans[stack.peek()]=i;
                stack.pop();
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
    private int[] getLeftSmallerElement(int nums[]) {
        int n = nums.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans,-1);

        for(int i=n-1;i>=0;i--) {
            int val = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]<val) {
                ans[stack.peek()]=i;
                stack.pop();
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
    public int trap(int[] height) {
        int n = height.length;
        int rle[] = getRightLargestElement(height);
        int lle[] = getLeftSmallerElement(height);
        int ans=0;
        // Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            if(rle[i]==n || lle[i]==-1) continue;
            else{
                int a = Math.abs(i-rle[i]);
                int b = Math.abs(i-lle[i]);
                int c = (a+b-1);
                System.out.println("index = " + i);
                // System.out.println("c = "+ c);
                int min = Math.min(height[rle[i]],height[lle[i]]);
                System.out.println("min = "+ min);
                int heg = Math.abs(min-height[i]);
                System.out.println("heg = "+ heg);
                // System.out.println("each  = " + (heg*c) );
                // String key = "" + rle[i] + "|" + lle[i];
                // if(set.add(key)) {
                //     ans += c*heg;
                // }
                ans += heg;
            }
        }
        return ans;
    }
}


/*Approach 2

min(lefmax,rightmax)-height[i]

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans=0;
        int leftmax=0;
        int rightmax=0;
        int left=0;
        int right=n-1;
        while(left<=right) {
            if(height[left]<=height[right]) {
                if(leftmax>height[left]) {
                    ans += leftmax-height[left];
                }
                else{
                    leftmax=height[left];
                }
                left++;
            }
            else{
                if(rightmax>height[right]) {
                    ans += rightmax-height[right];
                }
                else{
                    rightmax=height[right];
                }
                right--;
            }
        }
        return ans;
    }
}


*/
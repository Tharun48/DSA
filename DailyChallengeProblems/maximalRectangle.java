class Solution {
    private int[] getLeftSmallestElement(int nums[],int n) {
        int lse[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(lse,-1);
        for(int i=n-1;i>=0;i--) {
            int ele = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]>ele) {
                lse[stack.peek()]=i;
                stack.pop();
            }
            stack.push(i);
        }   
        return lse;
    }
    private int[] getRightSmallestElement(int nums[],int n) {
        int rse[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(rse,n);
        for(int i=0;i<n;i++) {
            int ele = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]>ele) {
                rse[stack.peek()]=i;
                stack.pop();
            }
            stack.push(i);
        }
        return rse;
    }
    private int findArea(int nums[]) {
        int n = nums.length;
        int lse[] = getLeftSmallestElement(nums,n);
        int rse[] = getRightSmallestElement(nums,n);
        System.out.println("DP = " + Arrays.toString(nums));
        System.out.println("LSE = " + Arrays.toString(lse));
        System.out.println("RSE = " + Arrays.toString(rse));
        int area = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            int left = Math.abs(i-lse[i]);
            int right = Math.abs(i-rse[i]);
            int length = left+right-1;
            int curArea = (length * nums[i]);
            area = Math.max(area,curArea);
            System.out.println("i = " + i + " area = " + area);
        }
        return area;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[] = new int[m];
        int maxArea=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                int val = matrix[i][j]-'0';
                if(val==0) {
                    dp[j]=0;
                }
                else{
                    dp[j] = dp[j] + 1;
                }
            }
            int getArea = findArea(dp);
            maxArea = Math.max(maxArea,getArea);
            System.out.println("maxArea = " + maxArea);
        }
        return maxArea;
    }
}
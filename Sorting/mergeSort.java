class Solution { 
    int ans=0;
    static void merge(int nums[],int n,int low,int mid,int high,int ans[]) {
        int cnt=0;
        int rightptr=mid+1;
        for(int i=low;i<=mid;i++) {
            while(rightptr<=high && nums[i]>nums[rightptr]) {
                rightptr++;
            }
            ans[0] += rightptr-(mid+1);
        }
        // System.out.println("ans = " + ans);
        int leftP=low;
        int rightP=mid+1;
        int temp[] = new int[high-low+1];
        int k=0;
        while(leftP<=mid && rightP<=high) {
            if(nums[leftP]>=nums[rightP]) {
                temp[k++]=nums[rightP];
                // tempSorted.add(nums[rightP]);
                rightP++;
            }
            else{
                temp[k++]=nums[leftP];
                // tempSorted.add(nums[leftP]);
                leftP++;
            }
        }
        while(leftP<=mid) {
            temp[k++]=nums[leftP];
            // tempSorted.add(nums[leftP]);
            leftP++;
        }
        while(rightP<=high) {
            temp[k++]=nums[rightP];
            // tempSorted.add(nums[rightP]);
            rightP++;
        }
        k=0;
        // System.out.println("temp = " + tempSorted);
        for(int i=low;i<=high;i++) {
            nums[i]=temp[k];
            k++;
        }
    }
    static void mergeSort(int nums[],int n,int low,int high,int ans[]) {
        if(low==high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSort(nums,n,low,mid,ans);
        mergeSort(nums,n,mid+1,high,ans);
        merge(nums,n,low,mid,high,ans);
    }
    static int countPairs(int nums[], int n) 
    {
        int ans[] = new int[1];
        for(int i=0;i<n;i++) {
            nums[i]=nums[i]*i;
        }
        mergeSort(nums,n,0,n-1,ans);
        return ans[0];
    }
}

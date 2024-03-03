package com.company;

public class SegmentTrees {
    int seg[];
    SegmentTrees(int n) {
        seg = new int[4*n];
    }
    void build(int index,int low,int high,int nums[]) {

        if(low==high) {
            seg[index]=nums[low];
            return ;
        }
        int mid = (low+high)/2;
        build(index*2+1,low,mid,nums);
        build(index*2+2,mid+1,high,nums);
        seg[index]=Math.min(seg[2*index+1],seg[2*index+2]);
    }
    int query(int index,int low,int high,int L,int R) {
        //1.no overlap
        //[low,high][L,R] or [L,R][low,high]
        if(high<L || R<low) {
            return Integer.MAX_VALUE;
        }
        else if(L<=low && R>=high) {
            return seg[index];
        }
        else {
            int mid = (low+high)/2;
            int left = query(index*2+1,low,mid,L,R);
            int right = query(index*2+2,mid+1,high,L,R);
            return Math.min(left,right);
        }
    }
    void update(int index,int low,int high,int i,int val) {

        if(low==high) {
            seg[index]=val;
            return ;
        }

        int mid = (low+high)/2;

        if(i<=mid) {
            update(index*2+1,low,mid,i,val);
        }
        else {
            update(index*2+2,mid+1,high,i,val);
        }
        seg[index] = Math.min(seg[index*2+1],seg[index*2+2]);
    }
}
class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nums[] = {2,1,0,5,4,3};
        int n = nums.length;
        SegmentTrees s = new SegmentTrees(n);

        s.build(0,0,n-1,nums);

        int t = sc.nextInt();

        while(t-->0) {
            int type = sc.nextInt();
            if(type==1) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(s.query(0,0,n-1,l,r));
            }
            else {
                int i=sc.nextInt();
                int val = sc.nextInt();
                s.update(0,0,n-1,i,val);
            }
        }

    }
}




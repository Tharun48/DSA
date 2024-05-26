import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = 1<<n;
        int m = sc.nextInt();
        int nums[] = new int[len];
        for(int i=0;i<len;i++) {
            nums[i]=sc.nextInt();
        }
        Segment s = new Segment(len);
        // System.out.println(Arrays.toString(nums));
        if(n%2==0) { 
            s.build(0,0,len-1,nums,false);
        }
        else{
            s.build(0,0,len-1,nums,true);
        }
        // System.out.println("ans = " + s.seg[0]);
        // System.out.println("seg = " + Arrays.toString(s.seg));
        for(int i=0;i<m;i++) {
            int ind = sc.nextInt();
            ind--;
            int val = sc.nextInt();
            if(n%2==0){
                // System.out.println("yes");
                s.update(0,0,len-1,false,ind,val);
                System.out.println(s.seg[0]);
            }
            else{
                s.update(0,0,len-1,true,ind,val);
                System.out.println(s.seg[0]);
            }
            
        }
    }
}
class Segment {
    int seg[][];
    Segment(int n) {
        seg = new int[n*4][3];
    }
    void build(int ind,int low,int high,int nums[],boolean flag) {
        if(low==high) {
            seg[ind]=nums[low];
            return ;
        }
        int mid = (low+high)/2;
        build(ind*2+1,low,mid,nums,!flag);
        build(ind*2+2,mid+1,high,nums,!flag);
        if(flag) {
            seg[ind]=seg[ind*2+1]|seg[ind*2+2];
        }
        else{
            seg[ind]=seg[ind*2+1]^seg[ind*2+2];
        }
        
    }
    void update(int ind,int low,int high,boolean f,int i,int val) {
        
        if(low==high) {
            seg[ind]=val;
            return ;
        }
        
        int mid = (low+high)/2;

        if(i<=mid) {
            update(ind*2+1,low,mid,!f,i,val);
        }
        else{
            update(ind*2+2,mid+1,high,!f,i,val);
        }

        if(f) {
            seg[ind]=seg[ind*2+1]|seg[ind*2+2];
        }
        else{
            seg[ind]=seg[ind*2+1]^seg[ind*2+2];
        }
    }
}

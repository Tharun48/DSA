import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        int n = str.length();
        int m = Integer.parseInt(br.readLine().trim());
        Segment s = new Segment(n);
        s.build(0,0,n-1,str);
        Scanner sc = new Scanner(System.in);
        int dp[][] = new int[n][n];
        for(int a[] : dp ) Arrays.fill(a,-1);
        while(m-->0) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken())-1;
            if(dp[left][right]==-1)
                dp[left][right]=s.query(0,0,n-1,left,right)[2];
            System.out.println(dp[left][right]*2);
        }
        
    }
}
class Segment {
    int seg[][];
    Segment(int n) {
        seg = new int[n*4][3];
    }
    void build(int ind,int low,int high,String s) {
        if(low==high) {
           if(s.charAt(low)=='(') {
            seg[ind][0]=1;
           }
           else {
            seg[ind][1]=1;
           }
           return ;
        }
        int mid = (low+high)/2;
        build(ind*2+1,low,mid,s);
        build(ind*2+2,mid+1,high,s);
        int min = Math.min(seg[ind*2+1][0],seg[ind*2+2][1]);

        seg[ind][0]=seg[ind*2+1][0]+seg[ind*2+2][0]-min;
        seg[ind][1]=seg[ind*2+1][1]+seg[ind*2+2][1]-min;
        seg[ind][2]=seg[ind*2+1][2]+seg[ind*2+2][2]+min;
    }
    int[] query(int ind,int low,int high,int L,int R) {
        //no overlap --> [low high L R ] [L R low high]
        //complete overlap --> [L low high R]
        if(high<L || R<low) {
            return new int[]{0,0,0};
        }
        else if(L<=low && high<=R){
            return seg[ind];
        }
        else{
            int mid=(low+high)/2;
            int left[] = query(ind*2+1,low,mid,L,R);
            int right[] = query(ind*2+2,mid+1,high,L,R);

            int min = Math.min(left[0],right[1]);
            int open = left[0]+right[0]-min;
            int close = left[1]+right[1]-min;
            int full = left[2]+right[2]+min;
            return new int[]{open,close,full};
        }
    }
}

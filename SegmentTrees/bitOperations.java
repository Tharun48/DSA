public class SegmentTrees {
    int seg[];
    SegmentTrees(int n) {
        seg = new int[4*n];
    }
    void build(int index,int low,int high,int nums[],boolean xorFlag) {

        if(low==high) {
            seg[index]=nums[low];
            return ;
        }
        int mid = (low+high)/2;
        build(index*2+1,low,mid,nums,!xorFlag);
        build(index*2+2,mid+1,high,nums,!xorFlag);
        if(xorFlag) {
            seg[index] = seg[index*2+1]^seg[index*2+2];
        }
        else{
            seg[index] = seg[index*2+1]|seg[index*2+2];
        }
    }
    void update(int index,int low,int high,int i,int val,boolean xorFlag) {

        if(low==high) {
            seg[index]=val;
            return ;
        }

        int mid = (low+high)/2;

        if(i<=mid) {
            update(index*2+1,low,mid,i,val,!xorFlag);
        }
        else {
            update(index*2+2,mid+1,high,i,val,!xorFlag);
        }

        if(xorFlag) {
            seg[index] = seg[index*2+1] ^ seg[index*2+2];
        }
        else{
            seg[index] = seg[index*2+1] | seg[index*2+2];
        }
    }
}

class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int el = (int)Math.pow(2,n);

        int nums[] = new int[el];
        for(int i=0;i<el;i++) {
            nums[i]=sc.nextInt();
        }
        SegmentTrees s = new SegmentTrees(el);
        if(n%2==0) {
            s.build(0,0,el-1,nums,true);
        }
        else {
            s.build(0,0,el-1,nums,false);
        }


        System.out.println(s.seg[0]);

        while(q-->0) {
            int ind = sc.nextInt();
            ind--;
            int val = sc.nextInt();
            if(n%2==0) {
                s.update(0,0,el-1,ind,val,true);
            }
            else {
                s.update(0,0,el-1,ind,val,false);
            }
            System.out.println(s.seg[0]);
        }
    }

    }
//339D codeforces

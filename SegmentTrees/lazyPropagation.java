public class LazyPropagation {
    int seg[];
    int lazy[];
    LazyPropagation(int n) {
        seg = new int[4*n];
        lazy = new int[4*n];
    }
    void build(int index,int low,int high,int nums[]) {

        if(low==high) {
            seg[index]=nums[low];
            return ;
        }
        int mid = (low+high)/2;
        build(index*2+1,low,mid,nums);
        build(index*2+2,mid+1,high,nums);
        seg[index]=seg[index*2+1] + seg[index*2+2];
    }

    int query(int index,int low,int high,int l,int r) {
        if (lazy[index] != 0) {
            seg[index] += (high - low + 1) * lazy[index];
            if (low != high) {
                lazy[2 * index + 1] += lazy[index];
                lazy[2 * index + 2] += lazy[index];
            }
            lazy[index] = 0;
        }
        if (r < low || high < l) {
            return 0;
        }
        else if (l<=low && high<=r){
            //complete overlap
            return seg[index];
        }
        else {
            int mid = (low+high)/2;
            int left = query(index*2+1,low,mid,l,r);
            int right = query(index*2+2,mid+1,high,l,r);
            return left+right;
        }
    }
    void update(int index,int low,int high,int l,int r,int val) {

        // if there is any update do that for lazy propagation

        if (lazy[index] != 0) {
            seg[index] += (high - low + 1) * lazy[index];
            if (low != high) {
                lazy[2 * index + 1] += lazy[index];
                lazy[2 * index + 2] += lazy[index];
            }
            lazy[index] = 0;
        }

        //no overlap
        //l r low high or low high l r

        if (r < low || high < l) {
            return ;
        }
        else if (l<=low && high<=r){
            //complete overlap
            seg[index] += (high-low+1)*val;
            if(low!=high) {
                lazy[index*2+1]+=val;
                lazy[index*2+2]+=val;
            }
            return ;
        }
        else {
            int mid = (low+high)/2;
            update(index*2+1,low,mid,l,r,val);
            update(index*2+2,mid+1,high,l,r,val);
            seg[index] = seg[index*2+1] + seg[index*2+2];
            return ;
        }
    }
}
class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();


        int nums[] = new int[n];
        for(int i=0;i<n;i++) {
            nums[i]=sc.nextInt();
        }
        LazyPropagation lz = new LazyPropagation(n);

        lz.build(0,0,n-1,nums);
        //System.out.println(lz.seg[0]);

        while(q-->0) {
            int type = sc.nextInt();
            //update
            if(type==1) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int val = sc.nextInt();
                lz.update(0,0,n-1,l,r,val);
            }
            else {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int ans = lz.query(0,0,n-1,l,r);
                System.out.println(ans);
            }

        }
    }

}

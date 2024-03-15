//LeetCode 2336
class SmallestInfiniteSet {
    boolean arr[];
    public SmallestInfiniteSet() {
        arr = new boolean[1001];
        Arrays.fill(arr,true);
    }
    public int popSmallest() {
        for(int i=1;i<1001;i++) {
            if(arr[i]) {
                arr[i] = false;
                return i;
            }
        }
        return 0;
    }
    public void addBack(int num) {
        if(!arr[num]) {
            arr[num] = true;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

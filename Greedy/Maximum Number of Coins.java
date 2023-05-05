class Solution {
    public int maxCoins(int[] piles) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : piles )
            heap.offer(n);
        int len = piles.length;
        int itr = len / 3;
        int ans = 0;
        while(itr>0) {
            heap.poll();
            ans += heap.poll();
            itr--;
        }
        return ans;
    }
}

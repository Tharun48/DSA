class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : stones ) {
            pq.offer(n);
        }
        while(!pq.isEmpty()) {
            int first = pq.poll();
            int second = 0;
            if(!pq.isEmpty()) {
                second = pq.poll();
            }
            if(second>0) {
                if(first-second>0) {
                    pq.offer(first-second);
                }
            }
            else {
                return first;
            }
        }
        return 0;
    }
}

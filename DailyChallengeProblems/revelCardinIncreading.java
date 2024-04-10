class Solution {
    private int getMinIndex(boolean vis[]) {
        int n = vis.length;
        for(int i=0;i<n;i++) {
            boolean flag = vis[i];
            if(!flag) return i;
        }
        return -1;
    }
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int ans[] = new int[n];
        List<Integer> sort = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            // list.add(i);
            sort.add(deck[i]);
        }
        Collections.sort(sort);
        
        // List<Integer> list = new ArrayList<>();

        while(list.size()!=n) {
            if(list.size()<1) {
                list.add(sort.get(sort.size()-1));
                sort.remove(sort.size()-1);
            }
            else{
                int v  = list.remove(list.size()-1);
                list.add(0,v);
                list.add(0,sort.get(sort.size()-1));
                sort.remove(sort.size()-1);
            }
            // System.out.println(list);
        }

        for(int i=0;i<n;i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
}

/* Approah 2 
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int ans[] = new int[n];
        Deque<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            q.offer(i);
        }
        Arrays.sort(deck);
        
        for(int i=0;i<n;i++) {
            ans[q.pollFirst()]=deck[i];
            if(q.size()>0) {
                int j = q.pollFirst();
                q.offerLast(j);
            }
        }
        return ans;
    }
}
 * 
 * 
 * 
 * 
 * 
*/

//leetcode daily challenge 10-04-2024..
//problem 950
//solve in reverse order...
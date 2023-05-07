class Pair {
    int score;
    int index;
    Pair(int score,int index) {
        this.score = score;
        this.index = index;
    }
}

class Solution
{
    public static int gfgGame(int N,int G,int require[],int receive[])
    {
     
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.score-b.score);
        
        int mini = require[0];
        for(int i=0;i<N;i++) {
            pq.offer(new Pair(require[i]-receive[i],i));
            mini = Math.min(mini,require[i]);
        }
        
        // System.out.println("mini = " + mini);
        
        int cnt = 0;
        
        while(!pq.isEmpty() && G>=mini) {
            if(require[pq.peek().index]<=G) {
                cnt++;
                G = G - pq.peek().score;
            }
            else {
                pq.poll();
            }
        }
        return cnt;
    }
}

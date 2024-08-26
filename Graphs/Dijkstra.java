class Node{
    int node;
    int weight;
    Node(int node,int weight) {
        this.node=node;
        this.weight=weight;
    }
}
class Pair {
    long distance;
    int node;
    Pair(long distance,int node) {
        this.distance = distance;
        this.node = node;
    }
}
class Solution
{
    static long[] dijkstra(int V, List<List<Node>> adj, int S)
    {
        long dist[] = new long[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.distance, b.distance));
        
        pq.offer(new Pair(0,S));
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[S] =0;
        
        while(!pq.isEmpty()) {
            Pair p = pq.peek();
            int node = p.node;
            long weight = p.distance;
            
            // System.out.println("node = " + node + " weigth = " + weight);
            
            
            pq.poll();
            int size = adj.get(node).size();
            
            for(int i=0;i<size;i++) {
                int neighBournode = adj.get(node).get(i).node;
                long neighBourWeight = adj.get(node).get(i).weight;
                if(dist[neighBournode] > (long)weight + neighBourWeight ) {
                    dist[neighBournode] = weight + neighBourWeight;
                    pq.offer(new Pair(weight + neighBourWeight,neighBournode));
                }   
            }
            
        }
        return dist;
    }
}

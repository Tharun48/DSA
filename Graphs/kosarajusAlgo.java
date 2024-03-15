

//User function Template for Java


class Solution
{
    private void bfs(int n,boolean vis[],Stack<Integer> stack,ArrayList<ArrayList<Integer>> adj) {
        vis[n]=true;
        for(int neighBour : adj.get(n) ) {
            if(!vis[neighBour]) {
                bfs(neighBour,vis,stack,adj);
            }
        }
        stack.push(n);
    }
    private void bfs2(int n,boolean vis[],ArrayList<ArrayList<Integer>> adj) {
        vis[n]=true;
        for(int neighBour : adj.get(n) ) {
            if(!vis[neighBour]) {
                bfs2(neighBour,vis,adj);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<ArrayList<Integer>> GraphRev = new ArrayList<>(V);
        for(int i=0;i<V;i++) GraphRev.add(new ArrayList<>());
        
        for(int i=0;i<adj.size();i++) {
            ArrayList<Integer> list = adj.get(i);
            for(int n : list ) {
                // System.out.println("n = " + n + " i = " + i);
                GraphRev.get(n).add(i);
            }
        }
        Stack<Integer> stack = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                bfs(i,vis,stack,adj);
            }
        }
        int scp=0;
        boolean v[] = new boolean[V];
        while(!stack.isEmpty()) {
            int n = stack.pop();
            if(!v[n]) {
                scp++;
                bfs2(n,v,GraphRev);
            }
        }
        return scp;
    }
}

class Solution {
    private List<List<Integer>> buildGraph(int edges[][],int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int a[] : edges ) {
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        return adj;
    }
    private List<Integer> getLeafNode(List<List<Integer>> adj,int n) {
        List<Integer> leaf = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(adj.get(i).size()==1) leaf.add(i);
        }
        return leaf;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }
        List<List<Integer>> adj = buildGraph(edges,n); 
        int degree[] = new int[n];
        for(int a[] : edges ) {
            degree[a[0]]++;
            degree[a[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(degree[i]==1) {
                q.offer(i);
            }
        }
        int remainingNode=n;
        while(remainingNode>2) {
            int size=q.size();
            remainingNode = remainingNode-size;
            for(int i=0;i<size;i++) {
                int curNode = q.poll();
                for(int neighBourNode : adj.get(curNode) ) {
                    degree[neighBourNode]--;
                    if(degree[neighBourNode]==1) {
                        q.offer(neighBourNode);
                    }
                }
            }
        }
        List<Integer> minimumHeightNodes = new ArrayList<>();
        while(!q.isEmpty()) {
            minimumHeightNodes.add(q.poll());
        }
        return minimumHeightNodes;
    }
}
//leetcode 310
//depth will be minimum if node lies centre..
//need to find centre of gravity..
//by removing the leaf nodes 
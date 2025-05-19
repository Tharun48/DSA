class Solution {
    private List<List<int[]>> buildGraph(int edges[][],int n) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());
        for(int a[] : edges ) {
            if(a[1]!=-1 && a[0]!=-1) {
                graph.get(a[0]).add(new int[]{a[1],a[2]});
                graph.get(a[1]).add(new int[]{a[0],a[2]});
            }
        }
        return graph;
    }
    private void dfs(int node,int parent,List<List<int[]>> graph,int up[][],int level[],int sum[],int wt) {
        level[node]=(parent>=0) ? level[parent]+1 : 1;
        up[node][0]=parent;
        sum[node]=wt;
        for(int i=1;i<18;i++) {
            if(up[node][i-1]!=-1)
                up[node][i]=up[up[node][i-1]][i-1];
        }
        for(int child[] : graph.get(node)) {
            if(child[0]==parent) continue;
            dfs(child[0],node,graph,up,level,sum,wt+child[1]);
        }
    }
    private int lca(int u,int v,int level[],int up[][]) {
        int depthU=level[u];
        int depthV=level[v];
        if(depthV>depthU) {
            int temp=u;
            u=v;
            v=temp;
        }
        int diffDepth = Math.abs(level[u]-level[v]);
        for(int i=0;i<18;i++) {
            if( (diffDepth & 1<<i)!=0) {
                u=up[u][i];
            }
        }
        if(u==v) return u;
        for(int i=17;i>=0;i--) {
            if(up[u][i]!=up[v][i]) {
                u=up[u][i];
                v=up[v][i];
            }
        }
        return up[u][0];
    }
    private int distance(int u,int v,int sum[],int level[],int up[][]) {
        int ancestor = lca(u,v,level,up);
        return (sum[u]+sum[v])-(2*sum[ancestor]);
    }
    public int[] minimumWeight(int[][] edges, int[][] queries) {
        int n = edges.length+1;
        List<List<int[]>> graph = buildGraph(edges,n);
        int level[] = new int[n];
        int up[][]=new int[n][18];
        int sum[] = new int[n];
        for(int a[] : up )
            Arrays.fill(a,-1);
        dfs(0,-1,graph,up,level,sum,0);
        int q = queries.length;
        int min[] = new int[q];
        for(int i=0;i<q;i++) {
            int a[] = queries[i];
            int ans=0;
            int s1 = a[0];
            int s2 = a[1];
            int d = a[2];
            int l = lca(s1,s2,level,up);
            ans+=distance(s1,s2,sum,level,up);
            ans+=distance(s1,d,sum,level,up);
            ans+=distance(s2,d,sum,level,up);
            min[i]=ans/2;
        }       
        // System.out.println(Arrays.toString(sum));
        return min;
    }
}

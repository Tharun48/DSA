class Solution
{
    int timer=0;
    private void targensAlgo(int node,int parent,int time[],int low[],ArrayList<ArrayList<Integer>> adj,boolean vis[],boolean points[]) {
        time[node]=timer;
        low[node]=timer;
        vis[node]=true;
        timer++;
        int childCount=0;
        for(int neighBour : adj.get(node) ) {
            if(neighBour!=parent) {
                if(!vis[neighBour]) {
                    targensAlgo(neighBour,node,time,low,adj,vis,points);
                    low[node] = Math.min(low[node],low[neighBour]);
                    if(low[neighBour]>=time[node] && parent!=-1) {
                        points[node]=true;
                    }
                }
                else {
                    low[node] = Math.min(low[node],time[neighBour]);                    
                }
            }
            childCount++;
        }
        if(childCount>1 && parent==-1) {
            points[node]=true;
        }
    }
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V];
        boolean artiPoints[] = new boolean[V];
        int time[]=new int[V];
        int low[]=new int[V];
        ArrayList<Integer> articulatedPoints = new ArrayList<>();
        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                targensAlgo(i,-1,time,low,adj,vis,artiPoints);
            }
        }
        for(int i=0;i<V;i++) {
            if(artiPoints[i]) articulatedPoints.add(i);
        }
        if(articulatedPoints.size()==0) {
            articulatedPoints.add(-1);
            return articulatedPoints;
        }
        return articulatedPoints;
    }
}

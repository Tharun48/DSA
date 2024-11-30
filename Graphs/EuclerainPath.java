class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    List<Integer> path;
    private Map<Integer,int[]> getDegree(int pairs[][]) {
        Map<Integer,int[]> map = new HashMap<>();
        //calculate the indegree and outdegree
        for(int a[] : pairs ) {
           if(map.containsKey(a[0])) {
                map.get(a[0])[1]++;
           }
           else{
                int temp[] = new int[]{0,1};
                map.put(a[0],temp);
           }
           if(map.containsKey(a[1])) {
                map.get(a[1])[0]++;
           }
           else{
                int temp[] = new int[]{1,0};
                map.put(a[1],temp);
           }
        }
        return map;
    }
    private int getStartNode(Map<Integer,int[]> degree) {
        int startNode=-1;
        for(Map.Entry<Integer,int[]> mpp : degree.entrySet() ) {
            if(mpp.getValue()[1]-mpp.getValue()[0]==1) {
                return mpp.getKey();
            }
            startNode=mpp.getKey();
        }
        return startNode;
    }
    private Map<Integer,List<Integer>> buildGraph(int pairs[][]) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int a[] : pairs ) {
            if(map.containsKey(a[0])) {
                map.get(a[0]).add(a[1]);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(a[1]);
                map.put(a[0],list);
            }
        }
        return map;
    }
    private void dfs(int node,Map<Integer,List<Integer>> graph,Map<Integer,int[]> degree) {
        // System.out.println("node = " + node + " graph = " + graph);
        while(degree.get(node)[1]!=0) {
            degree.get(node)[1]--;
            int nextNode = graph.get(node).remove(graph.get(node).size()-1);
            dfs(nextNode,graph,degree);
        }
        path.add(node);
    }
    public int[][] validArrangement(int[][] pairs) {        
        Map<Integer,int[]> degree = getDegree(pairs);
        path = new ArrayList<>();
        int startNode=getStartNode(degree);
        Map<Integer,List<Integer>> graph = buildGraph(pairs);
        // System.out.println("graph = " + graph);
        // System.out.println("start = " + startNode);
        int e=pairs.length;
        int order[][] = new int[e][2];
        dfs(startNode,graph,degree);
        // System.out.println("path = " + path);
        int k=0;
        for(int i=e;i>0;i--) {
            order[k][0] = path.get(i);
            order[k][1] = path.get(i-1);
            k++;  
        }
        return order;
    }   
}
//have idea about eulearian path
//question states that the graph has elurian path (if question does not states have to find if the graph has eulerian path or not using the indegree and outdegree)
//find the start node of the path
//implement the force DFS using the indegree and outdegree
//if the path length is e+1 then it is valid eulerain path else the graph is having multiple components having edges...

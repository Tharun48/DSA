class DisJoint{
    int parent[];
    int size[];
    DisJoint(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++) {
            size[i]=1;
            parent[i]=i;
        }
    }
    int findParent(int u) {
        if(parent[u]==u) return u;
        return parent[u]=findParent(parent[u]);
    }
    void union(int u,int v) {
        int ul_p_u = findParent(u);
        int ul_p_v = findParent(v);
        if(ul_p_u==ul_p_v) return ;
        if(size[ul_p_u]>size[ul_p_v]) {
            parent[ul_p_v]=ul_p_u;
            size[ul_p_u] += size[ul_p_v];
        }
        else {
            parent[ul_p_u]=ul_p_v;
            size[ul_p_v] += size[ul_p_u];
        }
    }
}
class Solution {
    private boolean isValid(int r,int c,int n) {
        if(r<0 || c<0 || r>=n || c>=n) return false;
        return true;
    }
    private int findMaxSize(int nums[]) {
        int size=0;
        for(int n : nums ) {
            size = Math.max(n,size);
        }
        return size;
    }
    public int largestIsland(int[][] grid) {
       int n = grid.length;
       //int m = grid[0].length;
        //int ans=Integer.MIN_VALUE;
        DisJoint dsj = new DisJoint(n*n);
        int row[] = {0,0,1,-1};
        int col[] = {1,-1,0,0};
        int cntZeros=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int r = i;
                int c =j;
                if(grid[i][j]==1) {
                    for(int k=0;k<4;k++) {
                        int dRow = r + row[k];
                        int dCol = c + col[k];
                        if(isValid(dRow,dCol,n) && grid[dRow][dCol]==1) {
                            int u = n*i + j;
                            int v = n*dRow + dCol;
                            dsj.union(u,v);
                        }
                    }
                }
                else {
                    cntZeros++;
                }
            }
        }
        // System.out.println(Arrays.toString(dsj.parent));
        // System.out.println(Arrays.toString(dsj.size));
        int ans = findMaxSize(dsj.size);
        if(cntZeros==0) return ans;
        else {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(grid[i][j]==0) {
                        int val=1;
                        Set<Integer> set = new HashSet<>();
                        for(int k=0;k<4;k++) {
                            int dRow = i + row[k];
                            int dCol = j + col[k];
                            if(isValid(dRow,dCol,n) && grid[dRow][dCol]==1) {
                                int v = n*dRow + dCol;     
                                int ul_p_v = dsj.findParent(v);
                                if(set.add(ul_p_v)) {
                                    val += dsj.size[ul_p_v];
                                }
                            }
                        }
                        ans = Math.max(val,ans);
                    }
                    //System.out.println("ans = " + ans + " i = " + i + " j = " + j);
                }
                
            }
        }
        return ans;
    }
}

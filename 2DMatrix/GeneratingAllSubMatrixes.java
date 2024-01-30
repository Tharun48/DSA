class Solution {
    private int getSum(int row,int col,int n,int m,int matrix[][]) {
        int sum=0;
        for(int i=row;i<=n;i++) {
            for(int j=col;j<=m;j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans=0;
        for(int rowStart=0;rowStart<n;rowStart++) {
            for(int rowEnd=rowStart;rowEnd<n;rowEnd++) {
                for(int colStart=0;colStart<m;colStart++) {
                    for(int colEnd=colStart;colEnd<m;colEnd++) {
                        if(getSum(rowStart,colStart,rowEnd,colEnd,matrix)==target) ans++;
                    }
                }
            }
        }
        return ans;
    }
}

class Solution {
    public void numSubmatrixSumTarget(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int rowStart=0;rowStart<n;rowStart++) {
            for(int rowSize=1;rowStart+rowSize<=n;rowSize++) {
                for(int colStart=0;colStart<m;colStart++) {
                    for(int colSize=1;colStart+colSize<=m;colSize++) {
                        System.out.println("rowStart = " + row + " colStart = " + col + " n = " + n + " m = " + m);
                    }
                }
            }
        }
    }
  public static void main(String args[]) {
    int matrix[][]={{0,1,0},{1,1,1},{0,1,0}};
    numSubmatrixSumTarget(matrix);
  }
}

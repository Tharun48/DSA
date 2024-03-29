//Approach 1 (Brute force):
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans=0;
        int preSum[][] = new int[n][m];
        for(int i=0;i<n;i++) {
            int sum=0;
            for(int j=0;j<m;j++) {
                sum += matrix[i][j];
                preSum[i][j]=sum;
            }
        }
        //System.out.println(Arrays.deepToString(preSum));
        for(int colStart=0;colStart<m;colStart++) {
            for(int colEnd=colStart;colEnd<m;colEnd++) {
                for(int rowStart=0;rowStart<n;rowStart++) {
                    int sum=0;
                    for(int rowEnd=rowStart;rowEnd<n;rowEnd++) {
                        //System.out.println("colStart = " + colStart + " colEnd = " + colEnd + " rowstart = " + rowStart + " rowEnd = " + rowEnd);
                        sum += preSum[rowEnd][colEnd] - (colStart>0 ? preSum[rowEnd][colStart-1] : 0);
                        if(sum==target) ans++;
                    }
                }
            }
        }
        return ans;
    }
}
//LC -> 1074
//TC -> (M*N)^2

//Approach 2 Using HashMap :
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans=0;
        int preSum[][] = new int[n][m];
        for(int i=0;i<n;i++) {
            int sum=0;
            for(int j=0;j<m;j++) {
                sum += matrix[i][j];
                preSum[i][j]=sum;
            }
        }
        //System.out.println(Arrays.deepToString(preSum));
        for(int colStart=0;colStart<m;colStart++) {
            for(int colEnd=colStart;colEnd<m;colEnd++) {
                Map<Integer,Integer> map = new HashMap<>();
                int sum=0;
                map.put(0,1);
                for(int row=0;row<n;row++) {
                    sum += preSum[row][colEnd] - (colStart>0 ? preSum[row][colStart-1] : 0);
                    int val = sum-target;
                    if(map.containsKey(val)) ans += map.get(val);
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }
        return ans;
    }
}


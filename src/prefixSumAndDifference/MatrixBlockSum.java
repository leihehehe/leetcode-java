package prefixSumAndDifference;

/**
 * Leetcode 1314
 */
public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        NumMatrix numMatrix = new NumMatrix(mat);
        int[][] res = new int[m][n];
        for(int i= 0;i<m;i++){
            for(int j=0;j<n;j++ ){
                int x1 = Math.max(i-k,0);
                int y1 = Math.max(j-k,0);
                int x2 = Math.min(i+k,m-1);
                int y2 = Math.min(j+k,n-1);
                res[i][j] = numMatrix.sumRegion(x1,y1,x2,y2);
            }
        }
        return res;
    }

    class NumMatrix{
        private int[][] preSum;
        public NumMatrix(int[][] mat){
            int m = mat.length, n = mat[0].length;
            if(m==0 || n==0) return;
            preSum = new int[m+1][n+1];
            for(int i = 1;i<m+1;i++){
                for(int j = 1;j<n+1;j++){
                    preSum[i][j] = preSum[i-1][j]+preSum[i][j-1]-preSum[i-1][j-1]+mat[i-1][j-1];
                }
            }
        }
        public int sumRegion(int x1, int y1, int x2, int y2){
            return preSum[x2+1][y2+1] - preSum[x2+1][y1] - preSum[x1][y2+1] + preSum[x1][y1];
        }
    }
}

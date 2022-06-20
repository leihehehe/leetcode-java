package prefixSumAndDifference;

/***
 * Leetcode 304. Range Sum Query 2D - Immutable
 * Acwing 796
 */
public class NumMatrix {
    private int[][] sums;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;//row
        int n = m==0?0:matrix[0].length;
        sums = new int[m+1][n+1];
        for(int i =1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                sums[i][j] = sums[i-1][j]+sums[i][j-1]-sums[i-1][j-1]+matrix[i-1][j-1];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        //sum has greater index compared to the original array
        row1++;
        col1++;
        row2++;
        col2++;
        return sums[row2][col2]-sums[row2][col1-1]-sums[row1-1][col2]+sums[row1-1][col1-1];
    }
}

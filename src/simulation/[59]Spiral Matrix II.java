package simulation;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, bottom = n-1, left = 0, right = n-1;
        int num = 1;
        //[left,right)
        //[top,bottom]
        while(num<=n*n){
            //first row
            for(int i = left;i<=right;i++){
                res[top][i] = num++;
            }
            top++;
            //last col
            for(int i = top;i<=bottom;i++){
                res[i][right]=num++;
            }
            right--;
            //last row
            for(int i = right;i>=left;i--){
                res[bottom][i] = num++;
            }
            bottom--;
            for(int i = bottom;i>=top;i--){
                res[i][left] = num++;
            }
            left++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

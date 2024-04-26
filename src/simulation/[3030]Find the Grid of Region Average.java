package simulation;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Weekly Contest -> Week 383
 * Medium
 * bruteforce -> simulation
 * Thinking: Given that 3 x 3 -> m x n, can you achieve O(mn)?
 */
class FindTheGridOfRegionAverage {
    private int[][] result;
    private int[][] count;
    private int sum = 0;
    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length;
        int n = image[0].length;
        result = new int[m][n];
        count = new int[m][n];
        //判断格子是否合法
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                //判断格子是否valid
                if(isValid(image, i, j, m, n, threshold, 1)){
                    //更新result
                    updateRes(sum, i, j,m,n);
                }
                sum=0;
            }
        }
        //更新平均值
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(count[i][j]!=0){
                    result[i][j]/=count[i][j];
                }else{
                    result[i][j] = image[i][j];
                }
            }
        }
        return result;

    }

    //判断合法的同时计算3x3网格的和
    public boolean isValid(int[][] image, int row, int col, int m, int n, int threshold, int depth){
        if(row+2>=m || col+2>=n) return false;
        //检查整个3x3网格是否合格
        for(int i = row;i<row+3;i++){
            for(int j = col;j<col+3;j++){
                sum+=image[i][j];
                //检查下面的格子是否合格（排除最下面的格子）
                if(i<row+2 && Math.abs(image[i][j]-image[i+1][j])>threshold){
                    return false;
                }
                //检查右边的格子是否合格（排除最右边的格子）
                if(j<col+2 && Math.abs(image[i][j]-image[i][j+1])>threshold){
                    return false;
                }
            }
        }
        return true;
    }
    //更新3x3网格的result
    public void updateRes(int sum,int row, int col, int m, int n){
        int avg = sum/9;
        for(int i = row;i<row+3;i++){
            for(int j = col;j<col+3;j++){
                result[i][j]+=avg;
                count[i][j]++;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

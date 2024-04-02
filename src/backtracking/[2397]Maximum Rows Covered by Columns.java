package backtracking;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximumRowsCoveredByColumnsSolution1 {
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j]==1){
                    rows[i]= rows[i]|(1<<j);
                }
            }
        }
        int ans = 0;
        for(int i = 0;i<(1<<n);i++){
            //iterate all the subsets
            int curCount = 0;
            if(Integer.bitCount(i) == numSelect){
                for(int row:rows){
                    if((row & i) == row){
                        curCount++;
                    }
                }
            }
            ans = Math.max(curCount,ans);
        }

        return ans;
    }
}
class MaximumRowsCoveredByColumnsSolution2 {
    int[] rows;
    int res = 0;
    int curChoose = 0;
    int count = 0;
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length;
        int n = matrix[0].length;
        rows = new int[m];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j]==1){
                    rows[i]= rows[i]|(1<<j);
                }
            }
        }
        dfs(0,matrix,numSelect);
        return res;
    }
    //which column to choose
    public void dfs(int i, int[][] matrix, int numSelect){
        if(count==numSelect){
            int curAns = 0;
            for(int row:rows){
                if(row==0 || (row & curChoose) == row){
                    curAns++;
                }
            }
            res = Math.max(res,curAns);
            return;
        }
        if(i==matrix[0].length) return;
        //chosen
        int prevChoose = curChoose;
        curChoose|=1<<i;
        count++;
        dfs(i+1,matrix,numSelect);
        curChoose = prevChoose;
        count--;
        //not chosen
        dfs(i+1,matrix,numSelect);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

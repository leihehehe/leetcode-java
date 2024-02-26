package dp;
class MinDistanceSolution1 {
    Integer[][] memo;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        memo = new Integer[n][m];
        return dfs(word1, word2, n-1, m-1);
    }

    public int dfs(String word1, String word2, int i, int j){
        //word1已经处理完了，删除所有word2
        if(i<0){
            return j+1;
        }
        //word2已经处理完了，删除所有word1
        if(j<0){
            return i+1;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            memo[i][j] = dfs(word1,word2,i-1,j-1);

        }else{
            memo[i][j] = Math.min(Math.min(dfs(word1,word2,i-1,j),dfs(word1,word2,i,j-1)),dfs(word1, word2, i-1, j-1))+1;
        }


        return memo[i][j];
    }
}
class MinDistanceSolution2 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] memo = new int[n+1][m+1];
        for(int j = 0;j<m;j++){
            memo[0][j+1] = j+1;
        }
        for(int i = 0;i<n;i++){
            memo[i+1][0] = i+1;
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    memo[i+1][j+1] = memo[i][j];
                }else{
                    memo[i+1][j+1] = Math.min(Math.min(memo[i][j+1],memo[i+1][j]),memo[i][j])+1;
                }
            }
        }
        return memo[n][m];
    }

}
class MinDistanceSolution3 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] memo = new int[m+1];
        for(int j = 0;j<m;j++){
            memo[j+1] = j+1;
        }


        for(int i = 0;i<n;i++){
            int prev = memo[0];
            memo[0]++;
            for(int j = 0;j<m;j++){
                int temp = memo[j+1];

                if(word1.charAt(i) == word2.charAt(j)){
                    memo[j+1] = prev;
                }else{
                    memo[j+1] = Math.min(Math.min(memo[j+1],memo[j]),prev)+1;
                }
                prev = temp;
            }
        }
        return memo[m];
    }

}
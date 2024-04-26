package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class CountTextsSolution1 {
    private final static int MODULE = (int)1e9+7;
    int[] memo;
    public int countTexts(String pressedKeys) {
        //每个按键对应多少个字母
        //0-10
        int n = pressedKeys.length();
        memo = new int[n];
        Arrays.fill(memo,-1);
        return dfs(n-1,pressedKeys);
    }
    //[0,i]的方案数
    public int dfs(int i, String pressedKeys){
        if(i==-1) return 1;
        if(i<-1) return 0;
        if(memo[i]!=-1) return memo[i];
        char c = pressedKeys.charAt(i);
        int count = getCount(c);
        int res = 0;
        for(int j =1;j<=count;j++){
            //this ensures the index is not out of scope
            if(i-j+1>=0 && pressedKeys.charAt(i+1-j)==c){
                res = (res + dfs(i-j,pressedKeys))%MODULE;
            }else{
                break;
            }
        }
        return memo[i] = res;
    }
    public int getCount(char c){
        if(c=='7' || c == '9') return 4;
        else return 3;
    }
}

class CountTextsSolution2 {
    private final static int MODULE = (int)1e9+7;
    public int countTexts(String pressedKeys) {
        //每个按键对应多少个字母
        //0-10
        int n = pressedKeys.length();
        int[] memo = new int[n+1];
        memo[0] = 1;
        for(int i = 0;i<n;i++){
            char c = pressedKeys.charAt(i);
            int count = getCount(c);
            int res = 0;
            for(int j = 1;j<=count;j++){
                //this ensures the index is not out of scope
                if(i-j+1>=0 && pressedKeys.charAt(i+1-j)==c){
                    res = (res + memo[i-j+1])%MODULE;
                }else{
                    break;
                }
            }
            memo[i+1] = res;
        }
        return memo[n];
    }

    public int getCount(char c){
        if(c=='7' || c == '9') return 4;
        else return 3;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package weeklyContest.dp;

import java.util.Arrays;

class GoodBinaryStringsSolution1 {
    private final static int MODULE = (int) 1e9 + 7;
    public int goodBinaryStrings(int minLength, int maxLength, int oneGroup, int zeroGroup) {
        memo = new int[maxLength+1];
        Arrays.fill(memo,-1);
        int res = 0;
        for(int i = minLength;i<=maxLength;i++){
            res = (res + dfs(oneGroup,zeroGroup,i))%MODULE;
        }
        return res;
    }
    int[] memo;
    public int dfs(int oneGroup, int zeroGroup, int curLen){
        if(curLen == 0){
            return 1;
        }
        if(curLen<0){
            return 0;
        }
        if(memo[curLen]!=-1) return memo[curLen];
        int res = 0;
        //choose one
        res = (res+ dfs(oneGroup,zeroGroup,curLen-oneGroup))%MODULE;
        //choose zero
        res = (res+ dfs(oneGroup,zeroGroup,curLen-zeroGroup))%MODULE;
        return memo[curLen] = res;
    }
}
class GoodBinaryStringsSolution2 {
    private final static int MODULE = (int) 1e9 + 7;
    public int goodBinaryStrings(int minLength, int maxLength, int oneGroup, int zeroGroup) {
        int[] memo = new int[maxLength+1];
        int res = 0;
        memo[0] = 1;
        for(int curLen = 1;curLen<=maxLength;curLen++){
            //choose one
            if(curLen>=oneGroup)
                memo[curLen] = (memo[curLen]+ memo[curLen-oneGroup])%MODULE;
            //choose zero
            if(curLen>=zeroGroup)
                memo[curLen] = (memo[curLen]+ memo[curLen-zeroGroup])%MODULE;
        }
        for(int i = minLength;i<=maxLength;i++){
            res = (res + memo[i])%MODULE;
        }
        return res;
    }

}
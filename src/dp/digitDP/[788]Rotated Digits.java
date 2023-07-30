package dp.digitDP;

import java.lang.reflect.Array;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    char[] s;
    int[][] memo;
    int[] checkArr = {0,0,1,-1,-1,1,1,-1,0,1};
    public int rotatedDigits(int n) {
        s = String.valueOf(n).toCharArray();
        int m = s.length;
        memo = new int[m][m];
        for(int i =0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        return getGoodInteger(0,0,true);
    }
    public int getGoodInteger(int i, int hasGoodIntegers, boolean isLimit){
        if(i==s.length){
            //1 or 0;
            return hasGoodIntegers;
        }
        if(!isLimit && memo[i][hasGoodIntegers]!=-1){
            return memo[i][hasGoodIntegers];
        }
        int res = 0;
        int up = isLimit?s[i]-'0':9;
        for(int d = 0;d<=up;d++){
            //if valid
            if(checkArr[d]!=-1){
                res += getGoodInteger(i+1,hasGoodIntegers | checkArr[d], isLimit && up==d);
            }
        }
        if(!isLimit){
            memo[i][hasGoodIntegers] = res;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

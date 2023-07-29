package dp.digitDP;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class CountSpecialIntegers {
    char[] s;
    int[][] memo;
    public int countSpecialNumbers(int n) {
        s = String.valueOf(n).toCharArray();
        int m = s.length;
        memo = new int[m][1<<10];
        for (int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1); // -1 表示没有计算过
        return count(0,0,true,false);
    }

    /**
     * 填充第i位，前面已填充数字为mask
     * @param i
     * @param mask
     * @return
     */
    public int count(int i, int mask,boolean isLimit, boolean isNum){
        if(i==s.length){
            //当前算一个
            return isNum?1:0;
        }
        //记忆化
        if(!isLimit && isNum && memo[i][mask]!=-1){
            return memo[i][mask];
        }
        int res = 0;
        //可以选择跳过当前位置，不填数字(也就是为0的情况)
        if(!isNum){
            res+=count(i+1,mask,false,false);
        }
        //也可以选择不跳过当前位置，填数字(如果没有limit就是[0,up]，limit就是[1,up])
        int up = isLimit?s[i]-'0':9;
        //枚举不同的情况
        for(int d = isNum?0:1;d<=up;d++){
            //d不在mask中，以保证数字只被使用过一次，是distinct的
            if((mask>>d&1)==0){
                res+=count(i+1,mask | (1<<d),isLimit && d==up,true);
            }
        }
        if(!isLimit && isNum){
            memo[i][mask]=res;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

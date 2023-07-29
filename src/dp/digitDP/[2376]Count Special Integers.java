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
     * 填充第i位，前面已填充数字为mask，方案数
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
class ANSFromSomeone {
    int[][] memo;   // memo[i][mask]记录当前选择顺位为i，已选状态为mask时，构造第i位及后面位的合法方案数
    char[] s;

    public int countSpecialNumbers(int n) {
        /*
        参考灵神の数位DP记忆化DFS模板：
        注意这题与LC1012是一样的，不过这题更直接求每一位都不相同数字
        dfs(i, mask, isLimit, hasNum) 代表从左到右选到第i个数字时(i从0开始)，前面数字已选状态为mask时的合法方案数
        各个参数的含义如下:
        i:当前选择的数字位次，从0开始
        mask:前面已择数字的状态，是一个10位的二进制数，如:0000000010就代表前面已经选了1
        isLimit:boolean类型，代表当前位选择是否被前面位的选择限制了；
            如n=1234，前面选了12，选第3位的时候会被限制在0~3，isLimit=true；否则是0~9，isLimit=false
        hasNum:表示前面是否已经选择了数字，若选择了就为true(识别直接构造低位的情况)
        时间复杂度:O(1024*M*10) 空间复杂度:O(1024*M)
        记忆化DFS的时间复杂度=状态数*每一次枚举的情况数
        **记忆化本质就是减少前面已选状态一致的情况，将1eM的时间复杂度压缩至1<<M，效率非常高**
         */
        s = String.valueOf(n).toCharArray();    // 转化为字符数组形式
        int m = s.length;
        memo = new int[m][1 << 10];     // i∈[0,m-1]，mask为一个10位二进制数
        // 初始化memo为-1代表该顺位下该已选状态还没进行计算
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        // 注意一开始最高位是有限制的，isLimit=true
        return dfs(0, 0, true, false);
    }

    // dfs(i, mask, isLimit, hasNum) 代表从左到右选第i个数字时，前面已选状态为mask时的合法方案数
    private int dfs(int i, int mask, boolean isLimit, boolean hasNum) {
        // base case
        // i越过最后一位，此时前面选了就算一个，没选的就不算，因为不选后面也没得选了
        if (i == s.length) return hasNum ? 1 : 0;
        // 已经计算过该状态，并且该状态是有效的，直接返回该状态
        // 这一步是降低时间复杂度的关键，使得记忆化dfs的时间复杂度控制得很低
        // !isLimit表示没有被限制的才可以直接得出结果，否则还要根据后面的数字进行计算子问题计算
        if (!isLimit && hasNum && memo[i][mask] != -1) return memo[i][mask];
        int res = 0;    // 结果
        // 本位可以取0(可直接构造低位数)的情况，此时要加上构造低位数0xxx的方案数
        // 将是否选了数字作为分类条件是为了避免出现00010这样有多个0的就不能统计了
        if (!hasNum) res = dfs(i + 1, mask, false, false);
        // 构造与当前顺位相同位数的数字就要枚举可选的数字进行DFS
        // 枚举的起点要视hasNum而定，如果前面选择了数字，那么现在可以选0；否则只能从1开始
        // 枚举得终点视isLimit而定，若被限制了只能到s[i]，否则可以到9
        for (int k = hasNum ? 0 : 1, end = isLimit ? s[i] - '0' : 9; k <= end; k++) {
            // 如果该数字k还没有被选中，那猫就可以选该位数字
            if (((mask >> k) & 1) == 0) {
                // 方案数遵循加法原理
                // i:进行下一位的DFS，因此为i+1
                // mask:由于该位选中了k，mask掩膜传下去就要更新，已选状态加上k
                // isLimit:当且仅当前面的被限制了且该位被限制
                // hasNum:该位选了必定为true
                res += dfs(i + 1, mask | (1 << k), isLimit && k == end, true);
            }
        }
        if (!isLimit && hasNum) memo[i][mask] = res;    // 如果前面没有限制，表明后面都是同质的，可以记录进memo中
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

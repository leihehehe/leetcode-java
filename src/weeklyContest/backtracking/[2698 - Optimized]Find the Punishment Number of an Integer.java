package weeklyContest.backtracking;

/**
 * Medium
 * Weekly Contest 346
 * Optimized solution -> use prefix sum in a static block
 */
class PunishmentNumber2 {
    private static final int[] PRE_SUM = new int[1001];
    static {
        for(int i = 1;i<=1000;i++){
            int squared = i * i;
            char[] s = Integer.toString(squared).toCharArray();
            PRE_SUM[i] = PRE_SUM[i-1]+ (dfs(s,i,0,0)?squared:0);
        }
    }
    public int punishmentNumber(int n) {
        return PRE_SUM[n];
    }
    /**
     * 分割s[index]到s[j]的子串
     * i是题目中的数字i
     */
    public static boolean dfs(char[] s, int i, int index, int sum){
        if(index == s.length){
            return i==sum;
        }
        int x = 0;
        for(int j = index;j<s.length;j++){
            //当前字串所代表的数字
            x = x * 10 + s[j] - '0';
            //分割[j+1...end]的字符串, 传递当前的sum
            if(dfs(s, i, j+1, sum+x)){
                return true;
            }
        }
        return false;
    }
}
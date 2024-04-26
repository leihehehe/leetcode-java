package backtracking;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Medium
 * Weekly Contest 346
 */
class PunishmentNumber {
    public int punishmentNumber(int n) {
        int res = 0;
        for(int i = 1;i<=n;i++){
            int squared = i * i;
            char[] s = Integer.toString(squared).toCharArray();
            if(dfs(s,0,i,0)){
                res+=squared;
            }
        }
        return res;
    }

    public boolean dfs(char[] s, int index, int i, int sum){
        if(index == s.length){
            return sum==i;
        }
        int num = 0;
        //extract substring -> [index,j]
        for(int j = index;j<s.length;j++){
            //current integer representation of s[index,j]
            num = num * 10 + s[j]-'0';
            //在[index,j]处分割后找到满足条件的结果
            if(dfs(s,j+1,i,sum+num)){
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package bitOperation;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximumGoodSolution1 {
    public int maximumGood(int[][] statements) {
        int n = statements.length;

        //[0,0,1],[1,1,0]
        int res = 0;
        for(int i = 0;i<1<<n;i++){
            int curRes = 0;
            for(int j = 0;j<n;j++){
                if(((i>>j)&1)==1){
                    //person j is good, check this
                    boolean valid = true;
                    for(int x = 0;x<statements.length;x++){
                        if(j==x) continue;
                        if(statements[j][x]==2) continue;
                        if(statements[j][x]!= ((i>>x)&1)){
                            //(1>>x)&1 是取出第x位的数字
                            valid = false;
                            break;
                        }
                    }
                    if(valid){
                        curRes++;
                    }else{
                        curRes = 0;
                        break;
                    }
                }
            }
            res = Math.max(curRes,res);
        }
        return res;

    }
}
class MaximumGoodSolution2 {
    int[] persons;
    int res = 0;
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        persons = new int[n];
        Arrays.fill(persons,-1);
        dfs(0,statements);
        return res;
    }
    public void dfs(int index, int[][] statements){
        if(index == statements.length){
            int curRes = 0;
            for (int person : persons) {
                if (person == 1) curRes++;
            }
            res = Math.max(curRes,res);
            return;
        }
        int prev = persons[index];
        //good
        persons[index] = 1;
        if(isValid(index, statements)){
            dfs(index+1,statements);
        }
        persons[index] = prev;

        persons[index] = 0;
        if(isValid(index,statements)){
            dfs(index+1,statements);
        }
        //not good
        persons[index] = prev;
    }

    public boolean isValid(int index, int[][] statements) {
        for (int i = 0; i <= index; i++) {
            if (persons[i] == 1) {  // 对于假设为好人的
                for (int j = 0; j < statements.length; j++) {
                    if (statements[i][j] == 2) continue;  // 没有明确的声明，跳过

                    // 如果某个人的陈述与已确定的状态不符，则返回 false
                    if (persons[j] != -1 && persons[j] != statements[i][j]) return false;
                }
            }
        }
        return true;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

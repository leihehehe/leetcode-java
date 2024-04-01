package backtracking;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class LetterCasePermutationSolution {
    List<String> res = new ArrayList<>();
    String s;
    public List<String> letterCasePermutation(String s) {
        this.s = s;
        dfs(0);
        return res;
    }
    StringBuilder sb = new StringBuilder();
    public void dfs(int i){
        if(i == s.length()){
            res.add(sb.toString());
            return;
        }
        //change or not change
        char c = s.charAt(i);
        //a letter
        if(Character.isLetter(c)){
            //change
            sb.append(Character.toUpperCase(c));
            dfs(i+1);
            sb.deleteCharAt(sb.length()-1);
            //not change
            sb.append(Character.toLowerCase(c));
            dfs(i+1);
            sb.deleteCharAt(sb.length()-1);
        }else{
            sb.append(c);
            dfs(i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

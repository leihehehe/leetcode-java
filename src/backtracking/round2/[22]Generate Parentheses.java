package backtracking.round2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        backtrack(n);
        return res;
    }
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int left=0, right=0;
    public void backtrack(int n){
        if(left<right) return;
        if(left>n || right>n) return;
        if(left==n && right==n) res.add(sb.toString());

        left++;
        sb.append('(');
        backtrack(n);
        sb.deleteCharAt(sb.length()-1);
        left--;

        right++;
        sb.append(')');
        backtrack(n);
        sb.deleteCharAt(sb.length()-1);
        right--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

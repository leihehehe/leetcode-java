package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        dfs(0,s,0,0);
        return new ArrayList<>(res);
    }

    Set<String> res = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    int max = 0;
    public void dfs(int i, String s, int left, int right){
        if(i==s.length()){
            if(left==right){
                if(sb.length()>max){
                    res.clear();;
                    res.add(sb.toString());
                    max = sb.length();
                }else if(sb.length()==max){
                    res.add(sb.toString());
                }

            }
            return;
        }

        char c = s.charAt(i);
        if(c=='('){
            sb.append(c);
            dfs(i+1,s,left+1,right);
            sb.deleteCharAt(sb.length()-1);
            //not chosen
            dfs(i+1,s,left,right);
        }else if(c==')'){
            if(left>right){
                sb.append(c);
                dfs(i+1,s,left,right+1);
                sb.deleteCharAt(sb.length()-1);
            }
            //not chosen
            dfs(i+1,s,left,right);
        }else{
            sb.append(c);
            dfs(i+1,s,left,right);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

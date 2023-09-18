package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BraaceExpansion {
    public String[] expand(String s) {
        backtrack(s,0);
        Collections.sort(res);
        return res.toArray(new String[0]);
    }
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public void backtrack(String s, int start){
        if(start==s.length()){
            res.add(sb.toString());
            return;
        }
        char c = s.charAt(start);
        if(c=='{'){
            int end = start+1;
            while(s.charAt(end)!='}'){
                //最后会得到'}'的位置
                end++;
            }
            String[] options = s.substring(start+1,end).split(",");
            for(String option:options){
                sb.append(option);
                backtrack(s,end+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }else{
            sb.append(c);
            backtrack(s,start+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

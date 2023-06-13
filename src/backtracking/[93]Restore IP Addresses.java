package backtracking;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class RestoreIPAddresses {
    List<String> res = new LinkedList<>();
    String upper = "255";
    public List<String> restoreIpAddresses(String s) {
        backtrack(s,0);
        return res;
    }
    LinkedList<String> path = new LinkedList<>();
    public void backtrack(String s, int start){
        if(start == s.length() && path.size() ==4){
            res.add(String.join(".",path));
            return;
        }
        if(start>=s.length())
            return;
        String str = s.substring(start,s.length());
        for(int i =0;i<3;i++){
            String choice = i+1<=str.length()?str.substring(0,i+1):str.substring(0,str.length());
            //if choice has a leading zero
            if(choice.length()>1 &&choice.charAt(0)=='0' )
                continue;
            //if choice > 255
            if(choice.length() == upper.length() && choice.compareTo(upper)>0){
                continue;
            }
            path.addLast(choice);
            backtrack(str,i+1);
            path.removeLast();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

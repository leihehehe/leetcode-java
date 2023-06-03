package backtracking;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class PalindromePartitioning {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtrack(s,0);
        return res;
    }
    LinkedList<String> path = new LinkedList<>();
    public void backtrack(String s,int index){
        if(index == s.length()){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i = index;i<s.length();i++){
            String choice = s.substring(index,i+1);
            if(!isPalindrome(choice))
                continue;
            path.addLast(choice);
            backtrack(s,i+1);
            path.removeLast();
        }
    }

    public boolean isPalindrome(String str){
        int i = 0, j = str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

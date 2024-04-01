package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class PalindromePartitioningSolution1 {
    List<List<String>> res = new ArrayList<>();
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0,0);
        return res;
    }
    List<String> path = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    //现在这个答案是否选[start,i]作为一个回文串？
    public void dfs(int i, int start){
        if(i==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        //not chosen 但最后一个字符是要选的
        if(i<s.length()-1)
            dfs(i+1,start);
        //chosen
        if(isPalindrome(start,i)){
            path.add(s.substring(start,i+1));
            dfs(i+1,i+1);
            path.remove(path.size()-1);
        }

    }
    public boolean isPalindrome(int start, int end){
        int i = start, j = end;
        while(i<=j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
class PalindromePartitioningSolution2 {
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

package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class RestoreIpAddressesSolution1 {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(0,s);
        return res;
    }
    List<String> path = new ArrayList<>();
    public void dfs(int index,String s){
        if(path.size()>4) return;
        if(index == s.length() && path.size()==4){
            res.add(String.join(".",path));
            return;
        }
        for(int i = index;i<s.length();i++){
            //extract the substring [index,i]
            String str = s.substring(index,i+1);
            if(!checkValidIP(str)){
                continue;
            }
            path.add(str);
            dfs(i+1,s);
            path.remove(path.size()-1);
        }
    }
    //if string == "0", return true
    //string != "0", it does have a leading zero, return false
    //string>255
    public boolean checkValidIP(String ip){
        if(ip.equals("0")) return true;
        if(ip.charAt(0)=='0') return false;
        //5525511135
        //255
        if(ip.length()>3) return false;
        if(Integer.compare(Integer.parseInt(ip), 255)>0) return false;
        return true;
    }
}
class RestoreIpAddressesSolution2 {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(0,0,s);
        return res;
    }
    List<String> path = new ArrayList<>();
    public void dfs(int start, int index,String s){
        if(path.size()>4) return;
        if(index==s.length()){
            if(path.size()!=4) return;
            res.add(String.join(".",path));
            return;
        }
        //first approach: decide whether we put dot at `index`

        //first case: put
        String str = s.substring(start,index+1);
        path.add(str);
        if(checkValidIP(str)){
            dfs(index+1,index+1,s);
        }
        path.remove(path.size()-1);
        if(index<s.length()-1){
            //second case: not put
            dfs(start, index+1,s);
        }
    }
    //if string == "0", return true
    //string != "0", it does have a leading zero, return false
    //string>255
    public boolean checkValidIP(String ip){
        if(ip.equals("0")) return true;
        if(ip.charAt(0)=='0') return false;
        //5525511135
        //255
        if(ip.length()>3) return false;
        if(Integer.compare(Integer.parseInt(ip), 255)>0) return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

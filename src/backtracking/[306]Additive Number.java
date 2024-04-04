package backtracking;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class IsAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        dfs(0,0,num);
        return res;
    }
    boolean res = false;
    List<String> path = new ArrayList<>();
    public void dfs(int start, int i, String num){
        if(res) return;
        if(i==num.length()){
            if(path.size()>=3) res = true;
            return;
        }
        //chosen
        String curNum = num.substring(start,i+1);
        if(curNum.charAt(0)=='0' && curNum.length()>1){
            //后面的结果都不可能valid
            return;
        }
        //not chosen, but must be chosen when it comes to the end
        if(i<num.length()-1){
            dfs(start,i+1,num);
        }
        path.add(curNum);
        if(path.size()<=2 || addStrings(path.get(path.size()-2),path.get(path.size()-3)).equals(path.get(path.size()-1))){
            dfs(i+1,i+1,num);
        }
        path.remove(path.size()-1);

    }
    private String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += num2.charAt(j--) - '0';
            }
            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package backtracking;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class LetterCombinationsOfaPhoneNumber {
    List<String> res = new LinkedList<>();
    String[] mapping = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return res;
        }
        backtrack(digits,0,new StringBuilder());
        return res;
    }
    public void backtrack(String digits, int start,StringBuilder sb){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
            return;
        }
        for(int i = start;i<digits.length();i++){
            int digit = digits.charAt(i)-'0';
            for(char letter: mapping[digit].toCharArray()){
                sb.append(letter);
                backtrack(digits,i+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

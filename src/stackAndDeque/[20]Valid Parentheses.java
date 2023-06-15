package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='{' || c=='(' || c=='[')
                stack.addLast(c);
            else{
                if(!stack.isEmpty() && getExpect(c)== stack.peekLast()){
                   stack.pollLast();
                }else
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public char getExpect(char c){
        if(c==')')
            return '(';
        if(c=='}')
            return '{';
        if(c==']')
            return '[';
        return '0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

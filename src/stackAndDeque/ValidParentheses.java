package stackAndDeque;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static javax.swing.UIManager.put;

/***
 * Leetcode 20
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<Character,Character>(){
            {
                put(')','(');
                put('}','{');
                put(']','[');
            }
        };
        Stack<Character> stack = new Stack<Character>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(pairs.containsKey(ch)){
                if(stack.isEmpty() || stack.pop()!=pairs.get(ch)){
                    return false;
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}

package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class SmallestSubsequenceOfDistinctCharacters {
    Deque<Character> stack = new ArrayDeque<>();
    int[] count = new int[26];
    boolean[] inStack = new boolean[26];
    public String smallestSubsequence(String s) {
        for(int i = 0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            count[c-'a']--;
            if(inStack[c-'a']) continue;
            while(!stack.isEmpty() && stack.peekLast()>c && count[stack.peekLast()-'a']>0){
                char remove = stack.pollLast();
                inStack[remove-'a']=false;
            }
            stack.addLast(c);
            inStack[c-'a']=true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

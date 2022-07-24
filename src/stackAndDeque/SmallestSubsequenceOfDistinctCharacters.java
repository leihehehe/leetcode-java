package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * Leetcode 1081 -> is the same as Leetcode 316
 */
public class SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] inStack = new boolean[26];
        int[] lastIndexes = new int[26];
        for(int i =0;i<s.length();i++){
            lastIndexes[s.charAt(i)-'a']=i;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(inStack[ch-'a']){
                continue;
            }
            while(!stack.isEmpty()&&ch<stack.peekLast()&&lastIndexes[stack.peekLast()-'a']>i){
                inStack[stack.pollLast()-'a']=false;
            }
            stack.addLast(ch);
            inStack[ch-'a']=true;
        }
        StringBuilder res = new StringBuilder();
        for(char ch : stack){
            res.append(ch);
        }
        return res.toString();
    }
}

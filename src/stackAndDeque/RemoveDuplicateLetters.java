package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * Leetcode 316 -> is the same as Leetcode 1081
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        int[] appear = new int[26];
        boolean[] visited = new boolean[26];
        //store last indexes of the elemnets
        for(int i =0;i<s.length();i++){
            appear[s.charAt(i)-'a']=i;
        }

        for(int i =0;i<s.length();i++){
            Character ch = s.charAt(i);
            if(visited[ch-'a']){
                continue;
            }else{
                while(!stack.isEmpty() && stack.peekLast()>ch && appear[stack.peekLast()-'a']>i){
                    visited[stack.pollLast()-'a']=false;
                }
                stack.addLast(ch);
                visited[ch-'a']=true;
            }
        }

        StringBuilder result = new StringBuilder();
        for(char c: stack){
            result.append(c);
        }
        return result.toString();
    }
}

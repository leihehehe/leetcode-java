import java.util.ArrayDeque;
import java.util.Deque;

public class Test {
        Deque<Character> deque = new ArrayDeque<>();
        boolean[] letters = new boolean[26];
        int[] count = new int[26];
    public String removeDuplicateLetters(String s) {
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }
        deque.addLast(s.charAt(0));
        for(int i = 1;i<s.length();i++){
            char c = s.charAt(i);
            count[c-'a']--;
            if(letters[c-'a'])
                continue;
            while(!deque.isEmpty() &&c<deque.peekLast()){
                if(count[deque.peekLast()-'a']>0){
                    letters[deque.pollLast()-'a']=false;
                }
            }
            deque.addLast(c);
            letters[c-'a']=true;
        }
        return deque.toString();
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.removeDuplicateLetters("cbacdcbc"));
    }

}

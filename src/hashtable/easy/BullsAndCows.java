package hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 299
 */
public class BullsAndCows {
    /**
     * Method 1: hashmap
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int bulls = 0;
        int cows = 0;
        Map<Character,Integer> map = new HashMap<>();

        for(int i =0;i<n;i++){
            if(secret.charAt(i)==guess.charAt(i)) bulls++;
            else{
                map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i),0)+1);
            }
        }

        for(int i =0;i<n;i++){
            int num = map.getOrDefault(guess.charAt(i),0);
            if(num!=0 && secret.charAt(i)!=guess.charAt(i)){
                cows++;
                map.put(guess.charAt(i),map.get(guess.charAt(i))-1);
            }
        }
        return bulls+"A"+cows+"B";
    }

    /**
     * Method 2: Array
     * @param secret
     * @param guess
     * @return
     */
    public String getHintMethod2(String secret, String guess) {
        int n = secret.length();
        int bulls = 0;
        int cows = 0;
        int[] map = new int[10];

        for(int i =0;i<n;i++){
            int secretNum =secret.charAt(i)-'0';
            int guessNum =guess.charAt(i)-'0';
            if(secretNum==guessNum) bulls++;
            else{
                map[secretNum]=map[secretNum]+1;
            }
        }

        for(int i =0;i<n;i++){
            int secretNum =secret.charAt(i)-'0';
            int guessNum =guess.charAt(i)-'0';
            int num = map[guessNum];
            if(num!=0 && secretNum!=guessNum){
                cows++;
                map[guessNum]=map[guessNum]-1;
            }
        }
        return bulls+"A"+cows+"B";
    }
}

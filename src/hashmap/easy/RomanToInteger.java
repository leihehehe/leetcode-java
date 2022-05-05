package hashmap.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {



    /***
     * Method 1: used hashmap to store roman and corresponding integers
     * Cons: when the data set is small, hashmap is slower than switch method(see method 2)
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int result=0;
        int n =s.length();
        for(int i =0;i<n;i++){
            int current = symbolValues.get(s.charAt(i));
            if(i<n-1 &&current<symbolValues.get(s.charAt(i+1))){
                result-=current;
            }else{
                result+=current;
            }
        }
        return result;
    }

    /***
     * Method 2: used switch, faster than hashmap when the dataset is small
     * @param s
     * @return
     */
    public int romanToIntMethod2(String s) {
        int result=0;
        int n =s.length();
        for(int i =0;i<n;i++){
            int current = getInteger(s.charAt(i));
            if(i<n-1 &&current<getInteger(s.charAt(i+1))){
                result-=current;
            }else{
                result+=current;
            }
        }
        return result;
    }

    public int getInteger(char roman){
        switch (roman){
            case 'I': return 1;
            case 'V':return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}

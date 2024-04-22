package weeklyContest.map;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class NumberOfSpecialCharsSolution1 {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        Set<Character> set = new HashSet<>();
        Set<Character> res = new HashSet<>();
        for(int i = 0;i<n;i++){
            char c = word.charAt(i);
            set.add(c);
            if(Character.isUpperCase(c) && set.contains(Character.toLowerCase(c))){
                res.add(Character.toLowerCase(c));
            }else if(Character.isLowerCase(c) && set.contains(Character.toUpperCase(c))){
                res.add(c);
            }
        }

        return res.size();
    }
}
class NumberOfSpecialCharsSolution2 {
    public int numberOfSpecialChars(String word) {
        Set<Character> letters = new HashSet<>();
        int n = word.length();
        for(int i = 0;i<n;i++){
            letters.add(word.charAt(i));
        }
        int count = 0;
        for(char upper='A', lower ='a';upper<='z';upper++,lower++){
            if(letters.contains(upper) && letters.contains(lower)){
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

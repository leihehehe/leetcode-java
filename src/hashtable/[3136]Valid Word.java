package hashtable;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class IsValidSolution {
    public boolean isValid(String word) {
        int n = word.length();
        if(n<3) return false;
        Set<Character> set = new HashSet<>();
        char[] chars = new char[]{'a','e','i','o','u'};
        for(char c: chars){
            set.add(c);
            set.add(Character.toUpperCase(c));
        }
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for(int i = 0;i<n;i++){
            char c = word.charAt(i);
            if(c=='@' || c=='#' || c=='$'){
                return false;
            }
            if(set.contains(c)){
                hasVowel=true;
            }else if(Character.isLetter(c)){
                hasConsonant = true;
            }
        }
        return hasVowel && hasConsonant;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

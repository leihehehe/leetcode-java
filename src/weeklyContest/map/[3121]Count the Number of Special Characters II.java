package weeklyContest.map;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class NumberOfSpecialChars {
    public int numberOfSpecialChars(String word) {
        //char -> integer
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(Character.isUpperCase(c)){
                map.putIfAbsent(c, i);
            }else{
                map.put(c, i);
            }
        }
        int count = 0;
        for(char lower= 'a', upper='A';lower<='z';lower++, upper++){
            if(map.containsKey(lower) && map.containsKey(upper) &&  map.get(lower)<map.get(upper)){
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

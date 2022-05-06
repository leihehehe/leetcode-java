package hashtable.middle;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstrWithoutRepeatingChar {

    /***
     * Method 1: sliding window using hashset
     * time complexity: O(n), this method does not consider the position of the previous existing letter, instead, it will iterate all the numbers for the left pointer
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int rightPointer=-1, result=0;
        HashSet storeSet = new HashSet();
        for(int i=0;i<s.length();i++){
            //every iteration, left pointer will move right by one step
            if (i != 0) {
                storeSet.remove(s.charAt(i - 1));
            }
            while(rightPointer+1<s.length() && !storeSet.contains(s.charAt(rightPointer+1))){
                //add all characters that right pointers pointed to
                storeSet.add(s.charAt(rightPointer+1));
                rightPointer++;
            }
            //select the max
            result = Math.max(result, rightPointer - i + 1);
        }
        return result;
    }
    /***
     * Method 2: sliding window using hashmap
     * time complexity: O(n)
     * This method will move left pointer in terms of the position of the previous existing character
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringHashMap(String s) {
        HashMap<Character,Integer> storeMap = new HashMap();
        int left=0, maxLen=0;
        //i will be considered right pointer
        for(int i=0;i<s.length();i++){
            //if the character exits, check if it is latter, if yes, update the left pointer to the position of character +1.
            if(storeMap.containsKey(s.charAt(i))){
                left = Math.max(left,storeMap.get(s.charAt(i))+1);
            }
            //update the max length
            maxLen=Math.max(i-left+1,maxLen);
            storeMap.put(s.charAt(i),i);
        }

        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringHashMap("aab"));
    }
}

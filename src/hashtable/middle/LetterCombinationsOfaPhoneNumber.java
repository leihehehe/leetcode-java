package hashtable.middle;

import java.util.*;

public class LetterCombinationsOfaPhoneNumber {
    /**
     * this method used Backtracking algorithm - dfs algorithm
     * used hashtable to store digits and corresponding letters.
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        //java 9 feature
        List<String> combinations = new ArrayList<String>();
        if(digits.length()==0){
            return combinations;
        }
        Map storeMap = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        dps(digits,storeMap,digits.length(),0,combinations,new StringBuilder());
        return combinations;
    }
    public static void dps(String digits,Map storeMap, int length, int depth, List<String> combinations,StringBuilder path){
        //if current layer is the last layer(image a tree)
        if(depth==length){
            combinations.add(path.toString());
            return;
        }
        //for example, digits=34=> the first layer will be 3, the second layer will be 4
        char digit = digits.charAt(depth);
        String letters = (String)storeMap.get(digit);
        for(int i =0;i<letters.length();i++){
            //if the node is not visited before
            path.append(letters.charAt(i));
            dps(digits,storeMap,length,depth+1,combinations,path);
            path.deleteCharAt(depth);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
}

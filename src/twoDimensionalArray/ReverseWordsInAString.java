package twoDimensionalArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode 151
 */
public class ReverseWordsInAString {
    /**
     * Method 1: split -> array -> reverse -> join
     * @param s
     * @return
     */
    public String reverseWordsMethod1(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split(" "));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    /**
     * Method 2: double pointers
     * @param s
     * @return
     */
    public String reverseWordsMethod2(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<s.length();i++){
            char c= s.charAt(i);
            if(c!=' ') sb.append(c);
            else if(s.charAt(i+1)!=' ') sb.append(c);
        }
        char[] chars = sb.toString().toCharArray();
        reverse(chars,0,chars.length-1);
        //hello world
        //dlrow olleh

        int j = 0;
        for(int i = 0;i<chars.length;i++){
            if(chars[i]==' '){
                reverse(chars,j,i-1);
                j=i+1;
            }else if(i==chars.length-1){
                reverse(chars,j,i);
            }
        }
        return new String(chars);
    }
    public void reverse(char[] arr, int i, int j){
        while(i<j){
            char temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}

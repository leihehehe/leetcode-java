package others;

/***
 * Lintcode 1784
 */
public class DecreaseToBePalindrome {
    /**
     * @param s: the string s
     * @return: the number of operations at least
     */
    public int numberOfOperations(String s) {
        // Write your code here
        int result=0;
        for(int i =0;i<s.length()/2;i++){
            result += Math.abs(s.charAt(i)-s.charAt(s.length()-1-i));
        }
        return result;
    }
}

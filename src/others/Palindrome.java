package others;

/***
 * Leetcode 9
 */
public class Palindrome {
    /**
     * Method 1: double pointers
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String target = String.valueOf(x);
        int i =0;
        int j = target.length()-1;
        while(i<j){
            if(target.charAt(i)!=target.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}

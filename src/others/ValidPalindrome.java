package others;

/***
 * offer 18
 */
public class ValidPalindrome {
    /***
     * Method 1: double pointers.
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        s=s.toLowerCase();
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

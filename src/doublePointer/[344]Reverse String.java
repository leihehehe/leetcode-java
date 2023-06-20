package doublePointer;

/**
 * Leetcode 344
 */
class ReverseString {
    public void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        while(i<j){
            swap(s,i,j);
            i++;
            j--;
        }
    }
    public void swap(char[] s, int i, int j ){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}

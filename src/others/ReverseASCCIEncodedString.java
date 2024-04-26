package others;

/***
 * Lintcode 1781
 */
public class ReverseASCCIEncodedString {
    /**
     * @param encodeString: an encode string
     * @return: a reversed decoded string
     */
    public String reverseAsciiEncodedString(String encodeString) {
        StringBuilder result = new StringBuilder();
        // Write your code here
        for(int i=encodeString.length();i>=2;i-=2){
            String strCode =encodeString.substring(i-2, i);
            int code = Integer.parseInt(strCode);
            result.append((char)code);
        }
        return result.toString();
    }
}

package doublePointer;

//leetcode submit region begin(Prohibit modification and deletion)
class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        //ba,gfedc
        reverse(chars, 0, n-1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left]=chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Space complexity is O(N) => substring will create a new char array to store the substring
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWordsMethod2(String s, int n) {
        String toAppend=s.substring(0,n);
        String first = s.substring(n,s.length());
        return first+toAppend;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

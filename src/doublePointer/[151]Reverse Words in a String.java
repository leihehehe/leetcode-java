package doublePointer;

//leetcode submit region begin(Prohibit modification and deletion)
class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int end = s.length();
        //[i,end) is a word
        for(int i = s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(c==' '){
                end = i;
            }else if (i==0 || s.charAt(i-1)==' '){
                sb.append(s.substring(i,end));
                if(i!=0)
                    sb.append(" ");
            }
        }
        return sb.toString();
    }


}
//leetcode submit region end(Prohibit modification and deletion)

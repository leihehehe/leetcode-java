package others;

//leetcode submit region begin(Prohibit modification and deletion)
class FinalString {
    public String finalString(String s) {
        //case 1: letter!='i', we append it to the stringbuilder
        //case 2: letter=='i', we reverse the stringBuilder but not append i
        //ouput sb.toString()
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'i') {
                sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

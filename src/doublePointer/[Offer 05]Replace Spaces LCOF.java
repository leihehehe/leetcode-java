package doublePointer;

//leetcode submit region begin(Prohibit modification and deletion)
class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==' ')
                sb.append("%20");
            else
                sb.append(c);
        }
        return sb.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

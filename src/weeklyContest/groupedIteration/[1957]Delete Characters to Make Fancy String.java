package weeklyContest.groupedIteration;

//leetcode submit region begin(Prohibit modification and deletion)
class MakeFancyString {
    public String makeFancyString(String s) {
        int i = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        while(i<n){
            sb.append(s.charAt(i));
            i++;
            while(i>1 && i<n && s.charAt(i) == s.charAt(i-1) && s.charAt(i) == s.charAt(i-2)){
                i++;
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

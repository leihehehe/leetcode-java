package stackAndDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int res = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(')
                left++;
            if(c==')'){
                if(left==0)
                    res++;
                else if(left>0){
                    left--;
                }
            }
        }
        return res+Math.abs(left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

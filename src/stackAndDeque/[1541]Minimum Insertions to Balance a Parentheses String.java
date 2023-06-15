package stackAndDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class MinimumInsertionsToBalanceAParenthesesString {
    public int minInsertions(String s) {
        int leftNeed = 0;
        int res = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                leftNeed+=2;
                if(leftNeed%2==1){
                    res++;
                    leftNeed--;
                }
            }
            if(c==')'){
                if(leftNeed==0){
                    res++;// 1 left
                    leftNeed+=1;//1 right
                }else
                    leftNeed--;

            }
        }

        return leftNeed+res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

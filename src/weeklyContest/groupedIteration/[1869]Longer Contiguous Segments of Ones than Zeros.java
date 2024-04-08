package weeklyContest.groupedIteration;

//leetcode submit region begin(Prohibit modification and deletion)
class CheckZeroOnes {
    public boolean checkZeroOnes(String s) {
        int i = 0;
        int n = s.length();
        //for 1
        int max1 = 0;
        int max0 = 0;
        while(i<n){
            char c = s.charAt(i);
            int start = i;
            i++;
            while(i<n && s.charAt(i)==c){
                i++;
            }
            if(c=='1'){
                max1 = Math.max(max1,i-start);
            }else{
                max0 = Math.max(max0,i-start);
            }
        }
        return max1>max0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package weeklyContest.groupedIteration;

//leetcode submit region begin(Prohibit modification and deletion)
class WinnerOfGame {
    public boolean winnerOfGame(String colors) {
        //AAABABB
        //AABABB
        //1>0
        //AAAABABBB
        //s   i

        //group(substring consists of same letters)
        //count the number of letters without the boundary
        //AAAA-> AA -> 2
        //pointer i -> points to the start of the group -> record as `start`
        //pointer i -> points to the end of the group
        //update ans
        //i = i'+1 = i++
        int i = 0;
        int n = colors.length();
        int countA = 0, countB = 0;
        while(i<n){
            int start = i;
            i++;
            while(i<n && colors.charAt(i)==colors.charAt(i-1)){
                i++;
            }
            int len = i-start-2;
            if(len>0){
                if(colors.charAt(start)=='A') countA+=len;
                else countB+=len;
            }
        }

        return countA>countB;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

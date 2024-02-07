package weeklyContest.simulation;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Medium
 * Weekly Contest -> Week 383
 */
class MinimumTimeToInitialState {
    public int minimumTimeToInitialState(String word, int k) {
        //three pointers
        int n = word.length();
        int p1 = 0;
        int p2 = Math.min(k, n);
        int check = p2;
        int len = 0;
        while(p2<n){
            //if charaters are not matched, adjust the pos of pointers
            if(word.charAt(p1)!=word.charAt(p2)){
                p1=0;
                len = 0;
                if(check+k>=n){
                    //exit the loop, no match found
                    break;
                }else{
                    //check next group
                    p2=check+k;
                    check = p2;
                }
            }else{
                //keep checking
                p1++;
                p2++;
                len++;
            }
        }
        // round up the result
        return (n-len+k-1)/k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

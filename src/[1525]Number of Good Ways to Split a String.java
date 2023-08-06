
//leetcode submit region begin(Prohibit modification and deletion)
class NumberOfGoodWaysToSplitAString {
    public int numSplits(String s) {
        int[] count = new int[26];
        int[] leftCount = new int[26];
        int rightLetter = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            //new letter
            if(count[c-'a']==0){
                rightLetter++;
            }
            count[c-'a']++;
        }
        int leftLetter = 0;
        int res = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(leftCount[c-'a']==0){
                leftLetter++;
            }
            leftCount[c-'a']++;
            if(count[c-'a']==leftCount[c-'a']){
                rightLetter--;
            }
            if(leftLetter==rightLetter){
                res++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

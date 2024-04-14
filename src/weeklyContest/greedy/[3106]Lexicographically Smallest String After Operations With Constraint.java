package weeklyContest.greedy;

//leetcode submit region begin(Prohibit modification and deletion)
class GetSmallestString {
    public String getSmallestString(String s, int k) {

        char[] chars = s.toCharArray();
        int n = chars.length;
        for(int i = 0;i<n;i++){
            //z->a
            char c = chars[i];
            int need = 'a'-c+26;
            int reverseNeed = c-'a';
            int minOps = Math.min(reverseNeed,need);
            //如果到a的距离小于k的操作数，那就直接变成a
            if(k>=minOps){
                chars[i] = 'a';
                k-=minOps;
            }else if(k>0){
                //如果到a的距离大于k的操作数：
                //比如c往后循环到a的距离大于k,那么往后加k没有意义，因为字母顺序一定会变大
                if(need>k){
                    chars[i] = (char)(reverseNeed-k+'a');
                }else{
                    //可以往后正向循环到a去
                    chars[i] = (char)(k-need+'a');
                }
                k=0;
            }else{
                break;
            }
        }
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

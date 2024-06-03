package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class BinaryGap {
    public int binaryGap(int n) {
        int lastIndex = -1;
        int distance = 0;
        int i = 0;
        while(n>0){
            if((n&1)==1){
                if(lastIndex!=-1)
                    distance = Math.max(distance, i-lastIndex);
                lastIndex = i;
            }
            n>>=1;
            i++;
        }

        return distance;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

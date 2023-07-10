package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestMountainInArray {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if(n<3) return 0;
        //以arr[i]为*结尾*的，*递增*的最长序列
        int[] up = new int[n];
        //以arr[i]为*开始*的，*递减*的最长序列
        //所以这道题就是求up[i]+down[i]的最大长度
        int[] down = new int[n];
        int maxLen = 0;
        //initialization
        for(int i =0;i<n;i++){
            up[i] = 1;
            down[i] = 1;
        }
        for(int i = 1;i<n;i++) if(arr[i]>arr[i-1]) up[i] = up[i-1]+1;
        for(int i = n-2;i>=0;i--){
            if(arr[i]>arr[i+1]) down[i] = down[i+1]+1;
            if(up[i]>1 && down[i]>1){
                maxLen = Math.max(maxLen,up[i]+down[i]-1);
            }
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

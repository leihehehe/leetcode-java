package dp.doubleArrayDP;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestTurbulentSubarray  {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        //以i结尾最后上扬的长度
        int[] up = new int[n];
        //以i结尾最后下降的长度
        int[] down = new int[n];
        Arrays.fill(up,1);
        Arrays.fill(down,1);
        for(int i = 1;i<n;i++){
            if(arr[i-1]<arr[i]){
                up[i] = down[i-1]+1;
                down[i] = 1;
            }else if (arr[i-1]>arr[i]){
                down[i] = up[i-1]+1;
                up[i] = 1;
            }else{
                up[i] = 1;
                down[i] = 1;
            }
        }

        int max =1;
        for(int i = 0;i<n;i++){
            max = Math.max(Math.max(down[i],up[i]),max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

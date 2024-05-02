package luogu;
//https://www.luogu.com.cn/problem/solution/P2642
import java.util.Scanner;
class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        long sum = 0;
        for(int i = 0;i<n;i++){
            nums[i] = scanner.nextInt();
            sum+=nums[i];
        }
        //case 1 不跨越数组尾部
        long max = getMax(n, nums);
        //case 2 跨越整个数组
        //找最小的两个连续子序列
        long min = getMin(n,nums);
        if(min == sum) System.out.println(max);
        else System.out.println(Math.max(sum-min,max));
    }

    private static long getMax(int n, int[] nums) {
        //case 1:找[0,n-1]中最大的两个连续子序列(这两个子序列之间不需要间隔)
        long[] startDp = new long[n];
        long[] endDp = new long[n];
        startDp[n -1] = nums[n -1];
        endDp[0] = nums[0];
        //现在存的是以i结尾的
        for(int i = 1; i< n; i++){
            endDp[i] = Math.max(endDp[i-1]+ nums[i], nums[i]);
        }
        //现在更新为以0-i之间的
        for(int i = 1; i< n; i++){
            endDp[i] = Math.max(endDp[i],endDp[i-1]);
        }
        for(int i = n -2; i>=0; i--){
            startDp[i] = Math.max(startDp[i+1]+ nums[i], nums[i]);
        }
        for(int i = n -2; i>=0; i--){
            startDp[i] = Math.max(startDp[i],startDp[i+1]);
        }
        long max = Long.MIN_VALUE;
        for(int i = 1; i< n -1; i++){
            //这里别写错了，是i和i+1，都写成i就重复了。。
            max = Math.max(endDp[i]+startDp[i+1],max);
        }
        return max;
    }
    private static long getMin(int n, int[] nums) {
        //case 1:找[0,n-1]中最小的两个连续子序列(这两个子序列之间不需要间隔)
        long[] startDp = new long[n];
        long[] endDp = new long[n];
        startDp[n -1] = nums[n-1];
        endDp[0] = nums[0];
        //现在存的是以i结尾的
        for(int i = 1; i< n; i++){
            endDp[i] = Math.min(endDp[i-1]+ nums[i], nums[i]);
        }
        //现在更新为以0-i之间的
        for(int i = 1; i< n; i++){
            endDp[i] = Math.min(endDp[i],endDp[i-1]);
        }
        for(int i = n -2; i>=0; i--){
            startDp[i] = Math.min(startDp[i+1]+ nums[i], nums[i]);
        }
        for(int i = n -2; i>=0; i--){
            startDp[i] = Math.min(startDp[i],startDp[i+1]);
        }
        long min = Long.MAX_VALUE;
        for(int i = 1; i< n - 1; i++){
            min = Math.min(endDp[i]+startDp[i+1],min);
        }
        return min;
    }
}
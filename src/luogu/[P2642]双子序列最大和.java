package luogu;
//https://www.luogu.com.cn/problem/solution/P2642
import java.util.Scanner;

class P2642{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        int[] startDp = new int[n];
        int[] endDp = new int[n];
        startDp[n-1] = nums[n-1];
        endDp[0] = nums[0];
        //现在存的是以i结尾的
        for(int i = 1;i<n;i++){
            endDp[i] = Math.max(endDp[i-1]+nums[i],nums[i]);
        }
        //现在更新为以0-i之间的
        for(int i = 1;i<n;i++){
            endDp[i] = Math.max(endDp[i],endDp[i-1]);
        }
        for(int i = n-2;i>=0;i--){
            startDp[i] = Math.max(startDp[i+1]+nums[i],nums[i]);
        }
        for(int i = n-2;i>=0;i--){
            startDp[i] = Math.max(startDp[i],startDp[i+1]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1;i<n-1;i++){
            max = Math.max(endDp[i-1]+startDp[i+1],max);
        }
        System.out.println(max);
    }
}
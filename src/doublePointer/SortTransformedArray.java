package doublePointer;

/**
 * Leetcode 360
 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int p1 = 0, p2 = nums.length-1;
        int[] res = new int[nums.length];
        if(a>0){
            int p = res.length-1;
            while(p1<=p2){
                int fx1 = a * (int)Math.pow(nums[p1],2) + b * nums[p1] + c;
                int fx2 = a * (int)Math.pow(nums[p2],2) + b * nums[p2] + c;
                if(fx1>fx2){
                    res[p] = fx1;
                    p1++;
                }else{
                    res[p] = fx2;
                    p2--;
                }
                p--;
            }
        }else{
            int p = 0;
            while(p1<=p2){
                int fx1 = a * (int)Math.pow(nums[p1],2) + b * nums[p1] + c;
                int fx2 = a * (int)Math.pow(nums[p2],2) + b * nums[p2] + c;
                if(fx1<fx2){
                    res[p] = fx1;
                    p1++;
                }else{
                    res[p] = fx2;
                    p2--;
                }
                p++;
            }
        }
        return res;
    }
}

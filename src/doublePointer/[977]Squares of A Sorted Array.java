package doublePointer;

/**
 * Leetcode 977
 */
class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int p = res.length-1;
        int l = 0, r = nums.length-1;
        while(l<=r){
            if(nums[l]*nums[l] < nums[r]*nums[r]){
                res[p] = nums[r]*nums[r];
                p--;
                r--;
            }else{
                res[p] = nums[l]*nums[l];
                p--;
                l++;
            }
        }
        return res;
    }
}

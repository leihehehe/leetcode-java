package binarySearch;

/***
 * Leetcode 410
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        //the range of the final result will be [max_num_of_nums, sum_of_nums]
        int max = 0, sum = 0;
        for(int num: nums){
            max = Math.max(num,max);
            sum+=num;
        }
        int l = max, r = sum;
        while(l<r){
            int mid = l+(r-l)/2;
            int split = getSplit(nums,mid);
            if(split>k) l  = mid +1;
            else r = mid;
        }
        return l;
    }
    public int getSplit(int[] nums, int sum){
        int currentSum = 0, split=1;
        for(int num:nums){
            if(currentSum+num>sum){
                currentSum=0;
                split++;
            }
            currentSum+=num;
        }
        return split;
    }
}

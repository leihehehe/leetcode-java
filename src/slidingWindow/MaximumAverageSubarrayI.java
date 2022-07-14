package slidingWindow;

/***
 * Leetcode 643
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        // k = 4
        //[1,12,-5,-6,50,3]
        //    i        j
        //sum = -1+50=-nums[i-1]+nums[j]
        //maxIndex = j;
        if(k>nums.length) return 0;
        int sum=0;
        //get the sum of the first window
        for(int i =0; i<k;i++){
            sum += nums[i];
        }
        //iterate the rest windows to get the largest average value
        //start from the second window
        int i=1,j = k,windowsSum=sum;
        while(j<nums.length){
            windowsSum = windowsSum-nums[i-1]+nums[j];
            sum = Math.max(sum,windowsSum);
            i++;
            j++;
        }
        return (double)sum/k;
    }
}

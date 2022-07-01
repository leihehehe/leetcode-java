package binarySearch;

import java.util.Arrays;

/***
 * Leetcode 611
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int total = 0;
        Arrays.sort(nums);
        for(int i =0;i<nums.length-2;i++){
            if(nums[i]==0) continue;
            for(int j =i+1; j<nums.length-1; j++){
                if(nums[j]==0) continue;
                int sum = nums[i]+nums[j], l = j+1, r = nums.length-1;
                while(l<r){
                    int mid = l+(r-l+1)/2;
                    if(nums[mid]>=sum) r = mid -1;
                    else l=mid;
                }
                if(nums[l]<sum) total+=r-j;
            }
        }
        return total;
    }
}

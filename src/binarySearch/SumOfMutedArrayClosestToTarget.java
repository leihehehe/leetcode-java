package binarySearch;

/**
 * Leetcode 1300
 */
public class SumOfMutedArrayClosestToTarget {
    public int findBestValue(int[] arr, int target) {
        //change x>value, and x in array, so value <= elements in array
        //find the largest number in the array
        int l = 0, r = 0;
        for(int num: arr){
            r= Math.max(num,r);
        }
        while(l<r){
            int mid = l+(r-l)/2;
            int sum = getSum(arr,mid);
            //find `sum` such that sum >=target
            if(sum<target){
                l = mid+1;
            }else{
                r=mid;
            }
        }
        int sum1 = getSum(arr,l);
        int sum2 = getSum(arr,l-1);
        //9, 11
        if(Math.abs(target-sum1)==Math.abs(target-sum2)) return l-1;
        else return Math.abs(target-sum1)<Math.abs(target-sum2)?l:l-1;
    }
    //all the integers that are greater than threshold should be replaced with threshold value.
    public int getSum(int[] arr, int threshold){
        int sum = 0;
        for(int num:arr){
            sum+=Math.min(num,threshold);
        }
        return sum;
    }
}

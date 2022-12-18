package binarySearch;

/**
 * Leetcode 1011
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int max = weights[0] , sum = 0;
        for(int weight : weights){
            max = Math.max(weight,max);
            sum+=weight;
        }
        int l = max, r = sum;
        while(l<r){
            int mid = l+(r-l)/2;
            if(getDays(weights,mid)>days) l = mid+1;
            else r = mid;
        }
        return l;
    }
    public int getDays(int[] weights, int capacity){
        int days = 1, cur = 0;
        for(int weight:weights){
            if(weight+cur>capacity){
                cur = 0;
                days++;
            }
            cur += weight;
        }
        return days;
    }
}

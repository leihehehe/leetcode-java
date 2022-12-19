package binarySearch;

/**
 * Leetcode 1482
 */
public class MinimumNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m>n/k) return -1;
        int l = Integer.MAX_VALUE, r = 0;
        for(int day: bloomDay){
            l = Math.min(l,day);
            r = Math.max(r,day);
        }
        while(l<r){
            int mid = l+(r-l)/2;
            int count = getFlowers(bloomDay,k,mid);
            if(count<m) l = mid+1;
            else r = mid;
        }
        return l;
    }
    public int getFlowers(int[] bloomDay, int k, int maxDay){
        int flowers = 0, bouquets = 0;
        for(int day:bloomDay){
            if(day<=maxDay){
                flowers++;
                if(flowers==k){
                    flowers=0;
                    bouquets++;
                }
            }else{
                flowers=0;
            }

        }
        return bouquets;
    }
}

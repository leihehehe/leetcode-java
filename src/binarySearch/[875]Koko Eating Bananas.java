package binarySearch;

/**
 * Leetcode 875
 */
class MinEatingSpeedSolution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile:piles) max = Math.max(max,pile);
        int l = 1, r = max;
        while(l<r){
            int mid = (l+r)/2;
            if(check(piles,h,mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    public boolean check(int[] piles, int h, int k){
        long total = 0;
        for(int i = 0;i<piles.length;i++){
            int p = piles[i];
            total += (p-1+k)/k;
            if(total>h) return false;
        }
        return true;
    }
}

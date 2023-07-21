package binarySearch;

/**
 * Leetcode 875
 */
class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for(int n : piles){
            r = Math.max(r,n);
        }

        while(l<r){
            int mid = l+(r-l)/2;
            int time = getTime(piles,mid);
            if(time>h){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return l;
    }
    public int getTime(int[] piles, int speed){
        int time = 0;
        for(int n : piles){
            time+= (n+speed-1)/speed;
        }
        return time;
    }
}

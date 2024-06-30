package binarySearch;

class MinimumTimeSolution {
    public long minimumTime(int[] time, int totalTrips) {
        long minTime = Long.MAX_VALUE;
        for(int t:time) minTime = Math.min(t,minTime);
        //最快的车跑totalTrips的时间
        long l = 1, r = totalTrips*minTime;
        while(l<r){
            long mid = (l+r)/2;
            if(check(time,totalTrips,mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    public boolean check(int[] time, int totalTrips, long requiredTime){
        //pick short time first
        long trips = 0;
        for(int i = 0;i<time.length;i++){
            int t = time[i];
            trips+=requiredTime/t;
            if(trips>=totalTrips) return true;
        }
        return false;
    }
}

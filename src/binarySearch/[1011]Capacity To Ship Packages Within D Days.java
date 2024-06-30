package binarySearch;

class ShipWithinDaysSolution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for(int w:weights) sum+=w;
        int l = 1, r = sum;
        while(l<r){
            int mid = (l+r)/2;
            if(check(weights,days,mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    public boolean check(int[] weights, int days, int capacity){
        int sum = 0;
        int dayCount = 1;
        for(int i = 0;i<weights.length;i++){
            int w = weights[i];
            if(w>capacity){
                return false;
            }else{
                sum+=w;
                if(sum>capacity){
                    sum = w;
                    dayCount++;
                }
            }

        }
        return dayCount<=days;
    }
}

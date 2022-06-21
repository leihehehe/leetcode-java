package prefixSumAndDifference;

/***
 * Leetcode 1109
 */
public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        //diff starts with 0, but booking starts with 1
        for(int[] booking : bookings){
            //diff[l]+=c
            diff[booking[0]-1]+=booking[2];
            //diff[r+1]-=c
            if(booking[1]<n) diff[booking[1]]-=booking[2];

        }
        for(int i =1; i< diff.length;i++){
            //diff[i-1] has already been re-set to the prefix sum, so we can just add it up.
            diff[i]+=diff[i-1];
        }
        return diff;
    }
}

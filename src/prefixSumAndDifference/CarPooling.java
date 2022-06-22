package prefixSumAndDifference;

import java.util.Arrays;

/***
 * Leetcode 1094
 */
public class CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] diff= new int[1000];
        //initialize diff array

        for(int[] trip: trips){
            diff[trip[1]]+=trip[0];
            //passengers have to drop at i
            if(trip[2]<diff.length)
                diff[trip[2]]-=trip[0];
        }

        for(int i=1;i<diff.length;i++){
            diff[i]+=diff[i-1];
        }
        for(int people: diff){
            if(people>capacity) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][] {{9,0,1},{3,3,7}};
        int c = 4;
        System.out.println(carPooling(nums,c));

    }
}

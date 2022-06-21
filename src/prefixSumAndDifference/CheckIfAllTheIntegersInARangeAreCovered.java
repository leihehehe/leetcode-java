package prefixSumAndDifference;

/***
 * Leetcode 1893
 * test:
 * ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 */
public class CheckIfAllTheIntegersInARangeAreCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        //initialize the difference array
        int[] diff = new int[51];
        for(int[] range:ranges){
            diff[range[0]-1]+=1;
            diff[range[1]]-=1;
        }
        //calculate the prefix sum
        for(int i =1; i< diff.length;i++){
            diff[i]+=diff[i-1];
        }
        for(int i = left-1;i<right;i++){
            if(diff[i]<=0)
                return false;
        }
        return true;
    }
}

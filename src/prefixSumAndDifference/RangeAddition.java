package prefixSumAndDifference;

/***
 * Leetcode 370
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        for(int[] update: updates){
            diff[update[0]]+=update[2];
            if(update[1]+1<length)
                diff[update[1]+1]-= update[2];
        }

        for(int i=1; i<length;i++){
            diff[i]+=diff[i-1];
        }
        return diff;
    }
}

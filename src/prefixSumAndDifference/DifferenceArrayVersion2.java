package prefixSumAndDifference;

import java.util.Arrays;

public class DifferenceArrayVersion2 {
    public static int[] addNumberToArray(int left, int right,int c,int[] nums){
        int[] diff= new int[nums.length+1];
        diff[0]=nums[0];
        for(int i =1;i< nums.length;i++){
            diff[i]=nums[i]-nums[i-1];
        }

        //add c to the diff
        diff[left-1]+=c;
        if(right< diff.length)
            diff[right]-=c;

        for (int i=1;i< diff.length;i++){
            diff[i]+=diff[i-1];
        }
        return diff;
    }
    public static void main(String[] args) {
        int[] arr= new int[]{1,3,4,2,5};
        //initialize the difference array

        System.out.println(Arrays.toString(addNumberToArray(2,4,3,arr)));

    }
}

package binarySearch;

import java.util.Arrays;

/**
 * Medium
 * Weekly Contest 386
 */
class EarliestSecondToMarkIndices {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int m = changeIndices.length;
        int l = 1, r = m;
        while(l<r){
            int mid = l+r>>1;
            if(check(nums,changeIndices, mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return check(nums,changeIndices, l)?l:-1;
    }

    public boolean check(int[] nums, int[] changeIndices,int time){
        int[] lastIndices = new int[nums.length];
        Arrays.fill(lastIndices, -1);
        //记录changeindices中每个下标值的最后一位
        for(int i = 0;i<time;i++){
            int curIndex = changeIndices[i]-1;
            lastIndices[curIndex] = i;
        }
        //每个nums的下标都应该对应changeIncies中的一个下标
        for(int t: lastIndices){
            if(t<0){
                return false;
            }
        }
        int count = 0;
        for(int i = 0;i<time;i++){
            int curIndex = changeIndices[i]-1;
            if(lastIndices[curIndex] == i){
                //需要标记，检查是否能标记
                if(count<nums[curIndex]){
                    //没有足够的操作数来-1
                    return false;
                }
                count-=nums[curIndex];
            }else{
                count++;
            }
        }
        return true;
    }
}
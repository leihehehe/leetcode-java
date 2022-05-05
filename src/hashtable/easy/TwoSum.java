package hashtable.easy;

import java.util.HashMap;

/***
 * 1. TwoSum
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap storeMap = new HashMap();
        //[2,5,7,3] => 9 => [0,2]
        for(int i=0;i<nums.length;i++){
            int need = target-nums[i];
            Object value = storeMap.get(need);
            if(value!=null){
                return new int[]{(int)value,i};
            }else{
                storeMap.put(nums[i],i);
            }
        }
        return new int[0];
    }
}

package binaryTree;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class PathSumIV {
    //code->node value
    Map<Integer,Integer> map = new HashMap<>();
    int sum =0;
    public int pathSum(int[] nums) {
        for(int num:nums){
            int code = num/10;
            int value = num%10;
            map.put(code,value);
        }
        traverse(nums[0]/10,0);
        return sum;
    }

    public void traverse(int code,int pathSum){
        if(!map.containsKey(code)) return;
        int depth = code/10;
        int pos = code%10;
        int value = map.get(code);
        pathSum+=value;
        int leftCode = (depth+1)*10 +pos*2-1;
        int rightCode =(depth+1)*10 + pos*2;
        if(!map.containsKey(leftCode) && !map.containsKey(rightCode)){
            sum+=pathSum;
            return;
        }
        traverse(leftCode,pathSum);
        traverse(rightCode,pathSum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

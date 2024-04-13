package doublePointer;

/**
 * Leetcode 167
 */
class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while(l<r){
            int sum = numbers[l]+numbers[r];
            if(sum==target){
                return new int[]{l+1,r+1};
            }
            if(sum>target){
                r = r-1;
            }
            if(sum<target){
                l = l+1;
            }
        }
        return new int[]{};
    }
}

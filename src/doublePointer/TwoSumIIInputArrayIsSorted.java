package doublePointer;

/**
 * Leetcode 167
 */
public class TwoSumIIInputArrayIsSorted {
    /**
     * Method 1: double pointers
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0, p2 = numbers.length-1;
        while(p1<p2){
            int sum = numbers[p1]+numbers[p2];
            if(sum>target) p2--;
            if(sum<target) p1++;
            if(sum==target) return new int[]{p1+1,p2+1};
        }
        return null;

    }
}

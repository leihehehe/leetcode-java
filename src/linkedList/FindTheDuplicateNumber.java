package linkedList;

/***
 * Leetcode 287
 */
public class FindTheDuplicateNumber {
    /***
     * Method 1: Double pointers and cycle linked list
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];//slow.next
            fast = nums[nums[fast]];//fast.next.next
            if(slow==fast){
                int pre1 = 0;
                int pre2 = slow;
                while(pre1 != pre2){
                    pre1 = nums[pre1];
                    pre2 = nums[pre2];
                }
                return pre1;
            }
        }
    }
}

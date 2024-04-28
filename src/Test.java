import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //[]
        int x = 4; // 示例中的 x 值
        int z = 4;  // 示例中的 z 值
        int y = x | z; // 计算 y 的值

        System.out.println("x = " + x);
        System.out.println("z = " + z);
        System.out.println("y = " + y);
        solution.minEnd(3,4);
    }

}
class Solution {
    public long minEnd(int n, int x) {
        int[] nums = new int[n];
        nums[0] = x; // 第一个元素为 x

        for (int i = 1; i < n; i++) {
            int bit = 1 << i;
            if ((nums[i - 1] & bit) == 0) { // 如果该位为 0，将该位设为 1
                nums[i] = nums[i - 1] | bit;
            } else { // 如果该位为 1，将该位设为 0
                nums[i] = nums[i - 1];
            }
        }


        return nums[n - 1]; // 返回最后一个元素的值
    }
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //len=1的情况：
        //len!=-1的情况：
        int l = nums2[0] - nums1[m-1];
        int r = nums2[n-1] - nums1[0];
        for(int x = l;x<=r;x++){
            if(check(x,nums1,nums2)) return x;
        }
        return 0;
    }
    public boolean check(int x, int[] nums1, int[] nums2){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums2){
            int num1 = num-x;
            map.put(num1,map.getOrDefault(num1,0)+1);
        }
        int count = 0;
        for(int num: nums1){
            map.put(num, map.getOrDefault(num,0)-1);
        }
        for(int num: nums2){
            int num1 = num-x;
            if(map.get(num1) <= 0){
                count++;
            }
        }
        return count==nums2.length;

    }
}
package doublePointer;

/**
 * Leetcode 88
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //[1,2,5,0,0,0] [3,4,6]
        //           p
        //     p1            p2

        int p = m+n-1, p1 = m-1, p2 =n-1;
        while(p1>=0&&p2>=0){
            if(nums1[p1]>nums2[p2]) nums1[p--]=nums1[p1--];
            else nums1[p--]=nums2[p2--];
        }
        while(p1>=0){
            nums1[p--]=nums1[p1--];
        }
        while(p2>=0){
            nums1[p--]=nums2[p2--];
        }
    }
}

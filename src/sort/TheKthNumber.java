package sort;

/***
 * acwing 786
 * O(n)
 * quick select => variant of quick sort
 */
public class TheKthNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,4,2,1};
        int n =nums.length, k = 2;
        System.out.println(quickSelect(0,nums.length-1,k,nums));

    }

    public static int quickSelect(int left, int right, int k, int[] nums){
        if(left>=right) return nums[right];
        int i =left-1,j = right+1,p = nums[j+(i-j)/2];
        while(i<j){
            do i++; while (nums[i]<p);
            do j--; while (nums[j]>p);
            if(i<j){
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        //the kth number = index k-1
        if(k-1<=j){
            return quickSelect(left,j,k,nums);
        }else{
            return quickSelect(j+1,right,k,nums);
        }

    }
}

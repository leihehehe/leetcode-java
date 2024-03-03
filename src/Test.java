public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{5,4,3,8};
        resultArray(nums);
    }
    public static int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int n1 = 0;
        arr1[n1] = nums[0];
        int[] arr2 = new int[n];
        int n2 = 0;
        arr2[n2] = nums[1];
        int[] res = new int[n];
        for(int i = 2;i<n;i++){
            if(arr1[n1]>arr2[n2]){
                arr1[++n1] = nums[i];
            }else{
                arr2[++n2] = nums[i];
            }
        }
        int end = 0;
        for(int i = 0;i<=n1;i++){
            res[i] = arr1[i];
            end = i;
        }
        end+=1;
        for(int i = 0;i<=n2;i++){
            res[end++] = arr2[i];
        }
        return res;
    }
}

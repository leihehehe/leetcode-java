package hashtable;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxSumSolution {

    public int maxSum(int[] nums) {
        int max = 0;
        //largest digit -> front pair
        int[] record = new int[10];
        Arrays.fill(record, -1);
        for(int num:nums){
            //get the largest digit
            int temp = num;
            int largest = temp%10;
            while(temp>0){
                int x = temp%10;
                largest = Math.max(x, largest);
                temp/=10;
            }
            if(record[largest]!=-1){
                max = Math.max(record[largest]+num,max);
            }else{
                record[largest]=num;
            }

            if(num>record[largest])
                record[largest]=num;
        }
        return max==0?-1:max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

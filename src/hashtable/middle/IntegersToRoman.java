package hashtable.middle;

import java.util.HashMap;

public class IntegersToRoman {

    /**
     * greedy algorithm, always pick the largest number so that the converted roman could be simple enough.
     * we have to list all the possible roman elements including IV, IX, etc.
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder = new StringBuilder();
        int index =0;
        while(index< romans.length){
            if (num >= nums[index]){
                stringBuilder.append(romans[index]);
                num-=nums[index];
            }else{
                //index cannot be incremented unless current number is larger than nums[index]
                index++;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(25));
    }
}

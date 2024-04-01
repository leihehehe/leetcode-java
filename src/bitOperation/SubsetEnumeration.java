package bitOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * Given that we have a set `{1,2,3}`, let's find out all the subsets: `{},{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}`. Therefore, we have **8** subsets(including the empty one).
 * A good approach to get all these subsets is using bits. Let's use one bit to represent a single element. Given `{1,2,3}`, we have 3 bits, and each bit represent an element.
 * For example, `000` represents `{}`, `001` represents `{3}`, because only the third bit is maked as `1(exists)`.
 * So actually, we are going to have 3 positions, and each position has two options(`0/1`), which means we have  `2^3 = 8` subsets(`000,001,010,011,100,101,110,111`).
 * Then, this can be written as `1<<3`, which means to take 1 left shifted by 3 bits, resulting in `1000` in binary.
 * We want to have an `111` , which is the last subset we would have for the set `{1,2,3}`.
 * Therefore, we can have a **for loop**, iterate the range`[0,1<<3)`, integers in this range represent the possible subsets.
 * Another **for loop** is used to get positions of the `1s` from these subsets representations in binary, so that we can get the actual numbers like `1,2,3`.
 */
public class SubsetEnumeration {
    public static void main(String[] args) {
        int[] set = {1,2,3};
        int n = set.length;
        for(int i = 0;i<(1<<n);i++){
            //this is for listing all the possible subsets in binary
            List<Integer> subset = new ArrayList<>();
            for(int j = 0;j<n;j++){
                if((1<<j & i) !=0){
                    //that means 1<<j is 1, so the jth postion of i is 1.
                    subset.add(set[j]);
                }
            }
            System.out.println(subset);
        }
    }
}

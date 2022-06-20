package prefixSum;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/***
 * acwing 797
 */
public class DifferenceArray {
    static int  N = 100010;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] nums = new int[N];
        int[] diff = new int[N];

        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
        }

        for(int i=1;i<=n;i++) {
            insert(diff, i, i, nums[i]);
        }

        while(m-->0) {
            int l,r,c;
            l = scanner.nextInt();
            r = scanner.nextInt();
            c = scanner.nextInt();
            insert(diff, l, r, c);
        }

        //diff[i] = diff[i-1] + diff[i]
        for(int i=1;i<=n;i++)nums[i] = nums[i-1]+diff[i];

        for(int i=1;i<=n;i++)System.out.print(nums[i]+" ");
        System.out.println();
        scanner.close();
    }

    //insert
    public static void insert(int[] a,int l,int r,int c) {
        a[l]+=c;
        a[r+1]-=c;
    }

}

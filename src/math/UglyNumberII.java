package math;

/**
 * Leetcode 264
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        //ugly number = 2^a * 3^b * 5^c
        int p2 = 1, p3 =1, p5 = 1;
        int product2 = 1, product3 = 1, product5 = 1;
        int[] ugly = new int[n+1];
        int p = 1;
        //[0..p) sorted
        while(p<=n){
            int min = Math.min(Math.min(product2,product3),product5);
            ugly[p] = min;
            p++;
            if(min==product2) product2= 2*ugly[p2++];
            if(min==product3) product3=3*ugly[p3++];
            if(min==product5) product5=5*ugly[p5++];

        }
        return ugly[n];
    }
}

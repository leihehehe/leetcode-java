package binarySearch;

public class Solution {
    
    public double mySqrt(double x) {
        double l = 0.0, r = x;
        double epsilon = 1e-2;
        
        while (l<r) {
            double mid = (l + r) / 2.0;
            if (x < mid * mid) {
                //每次增加就小一点，这样就不会那么快l==r从而退出循环
                r = mid-epsilon;
            } else {
                l = mid;
            }
        }
        
        return Math.round(l*100.0)/100.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2.0));
    }
}

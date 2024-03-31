package weeklyContest.math;

/**
 * Easy
 * Weekly Contest 391
 */
public class HarshadNumber {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int t = x;
        while(t>0){
            int r = t%10;
            sum+=r;
            t/=10;
        }
        return x%sum==0?sum:-1;

    }
}

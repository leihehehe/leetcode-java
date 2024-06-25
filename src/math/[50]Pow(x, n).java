package math;

class MyPowSolution {
    public double myPow(double x, int n) {
        double ans = 1;
        boolean rev = false;
        long n1 = n;
        if(n<0){
            rev = true;
            n1 = -n1;
        }
        while(n1>0){
            if((n1&1)== 1){
                ans = x * ans;
            }
            x = x*x;
            n1>>=1;
        }
        return rev?1/ans:ans;
    }
}
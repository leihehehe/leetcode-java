package math;

class NumberOfChild {
    public int numberOfChild(int n, int k) {
        //n-1秒
        //和leetcode 2582一样
        int t = k % (n-1);
        if(k/(n-1) % 2 == 0){
            return t;
        }
        return n-t-1;
    }
}

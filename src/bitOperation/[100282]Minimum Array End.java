package bitOperation;

class MinEndSolution {
    public long minEnd(int n, int x) {
        long res = x;
        n--;//x it self counts
        int i = 0, j = 0;
        while((n>>j)>0){
            if(((res>>i)&1) == 0){
                //add n-1
                res |=(long) ((n>>j)&1)<<i;
                j++;
            }
            i++;
        }
        return res;
    }
}
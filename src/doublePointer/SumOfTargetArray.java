package doublePointer;

/***
 * Acwing 800
 */
public class SumOfTargetArray {

    public int[] getSumArray(int[]a, int[] b, int x){
        int[] res = new int[2];
        for (int i =0, j =b.length-1; i<a.length;i++){
            while(j>=0 && a[i]+b[j]>0) j--;
            if(j>=0 && a[i]+b[j]==x){
                res[0]=i;
                res[1]=j;
            }
        }
        return res;
    }

}

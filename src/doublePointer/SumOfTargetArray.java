package doublePointer;

/***
 * Acwing 800
 */
public class SumOfTargetArray {

    public int[] getSumArray(int[]a, int[] b, int x){
        int[] res = new int[2];
        for (int i =0, j =b.length-1; i<a.length;i++){
            while(j>=0 && a[i]+b[j]>x) j--;
            if(j>=0 && a[i]+b[j]==x){
                res[0]=i;
                res[1]=j;
                break;
            }
        }
        return res;
    }

    public int[] getSumArrayMethod2(int[]a, int[] b, int x){
        int[] res= new int[2];
        int i=0,j= b.length-1;
        while(i<= a.length-1 && j<=b.length-1){
            if(a[i]+b[j]>x) j--;
            else i++;
            if(a[i]+b[j]==x){
                res[0]=i;
                res[1]=j;
                break;
            }
        }
        return res;
    }

}

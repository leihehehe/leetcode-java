package sort;

/***
 * Acwing 790
 */
public class CubeRoot {
    public void cubeRoot(int x){
        double l = 0, r=x;
        while(r-l>=1e-10){
            double mid = l+(r-l)/2;
            if(mid*mid*mid<=x){
                //float
                l=mid;
            }else{
                r=mid;
            }
        }
        System.out.printf("%.6f\n", r);
    }
}

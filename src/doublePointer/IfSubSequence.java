package doublePointer;

import java.util.Scanner;

/***
 * acwing 2816
 * leetcode 392
 */
public class IfSubSequence {
    public static boolean checkIfSubSequence(int[] a, int[] b){
        int i=0,j=0,m=a.length,n=b.length;
        while(i<m && j<n){
            if(a[i]==b[j]) i++;
            j++;
        }
        return i==m;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,5};
        int[] b = new int[]{1,2,3,4,5};
        System.out.println(checkIfSubSequence(a,b));
    }

    public static void scannerVersion(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i = 0 ; i < n ; i ++ ) a[i] = scan.nextInt();
        for(int i = 0 ; i < m ; i ++ ) b[i] = scan.nextInt();
        boolean res=false;
        for(int i =0, j=0; j<m;j++){
            if(i==n-1 && a[i]==b[j]){
                res=true;
            }
            if(i<n-1 && a[i]==b[j]) i++;
        }

        if(res) System.out.println("Yes");
        else System.out.println("No");
    }

    //leetcode 392
    public boolean isSubsequence(String s, String t) {
        int i =0,j=0,m=s.length(),n=t.length();

        while(i<m && j<n){
            if(s.charAt(i)==t.charAt(j)) i++;
            j++;
        }

        return i==m;

    }
}

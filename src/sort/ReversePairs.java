package sort;

/***
 * offer 51
 * acwing 788
 */
public class ReversePairs {
    public int count;
    public void mergeSort(int l, int r, int[] nums){
        if(l>=r) return;
        int mid = l+(r-l)/2;
        mergeSort(l,mid,nums);
        mergeSort(mid+1,r,nums);
        int[] temp = new int[r-l+1];
        int k=0, i=l, j=mid+1;
        while(i<=mid&&j<=r){
            if(nums[i]<=nums[j]) temp[k++]=nums[i++];
            else{
                temp[k++]=nums[j++];
                count+=mid-i+1;
            }
        }
        while(i<=mid) temp[k++]=nums[i++];
        while(j<=r) temp[k++]=nums[j++];
        //assign
        for(int a =l,b=0;a<=r;a++,b++){
            nums[a]=temp[b];
        }
    }
}

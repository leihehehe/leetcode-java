package binarySearch;

/***
 * Leetcode 744
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int l =0, r = letters.length-1;
        while(l<r){
            int mid =l+(r-l)/2;
            if(letters[mid]>target) r = mid;
            else l = mid +1;
        }
        if(letters[l]<=target) return letters[0];
        return letters[l];
    }
}

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] a, int target) {
        if (a == null || a.length == 0) {
            return 0;
        }
        
        int start = 0;
        int end = a.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (target <= a[start]) {
            return start;
        }
        
        if (target > a[end]) {
            return end + 1;
        }
        
        return end;        
    }
}


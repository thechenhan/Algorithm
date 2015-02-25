public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = a.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == a[mid]) {
                return mid;
            }
            if (a[start] < a[mid]) {
                if (target >= a[start] && target < a[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }          
            } else {
                if (target > a[mid] && target <= a[end]) {
                    start = mid;
                } else {
                    end = mid;
                }   
            }
        }
        
        if (a[start] == target) {
            return start;
        }
        
        if (a[end] == target) {
            return end;
        }
        
        return -1;
    }
}
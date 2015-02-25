class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] a) {
        if (a == null || a.length == 0){
            return 0;
        }
        
        int start = 0;
        int end = a.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                return mid;
            } else if (a[mid - 1] < a[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }    
        }
        
        return 0;
    }
}
class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] a, int m, int[] b, int n) {
        if (a == null || b == null) {
            return;
        }
        
        int pos = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (a[i] >= b[j]) {
                a[pos] = a[i];
                i--;
            } else {
                a[pos] = b[j];
                j--;
            }
            pos--;
        }
        
        if (i < 0) {
            while (pos >= 0) {
                a[pos] = b[j];
                j--;
                pos--;
            }
        } else {
            while (pos >=0) {
                a[pos] = a[i];
                i--;
                pos--;               
            }
        }
        
    }
}
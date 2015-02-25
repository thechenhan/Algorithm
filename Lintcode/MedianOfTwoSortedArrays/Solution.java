class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0; 
        } else {
            return (findKth(A, 0, B, 0, len / 2 + 1));
        }
    }
    
    public static int findKth(int[] a, int aStart, int[] b, int bStart, int k){
        if (aStart >= a.length) {
            return b[bStart + k - 1];
        }
        
        if (bStart >= b.length) {
            return a[aStart + k - 1];
        }
     
        if (k == 1) {
            return Math.min(a[aStart], b[bStart]);
        }
        
        int keyA = (k / 2 + aStart > a.length) ? Integer.MAX_VALUE : a[k / 2 + aStart - 1];
        int keyB = (k / 2 + bStart > b.length) ? Integer.MAX_VALUE : b[k / 2 + bStart - 1];
        
        if (keyA < keyB) {
            return findKth(a, k / 2 + aStart, b, bStart, k - k / 2);
        } else {
            return findKth(a, aStart, b, k / 2 + bStart, k - k / 2);
        }
    }
}
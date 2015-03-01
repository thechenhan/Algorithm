class Solution {
    /**
     * @param A: An integer array.
     * @return an integer array
     */
    public int[] rerange(int[] A) {
        // write your code here
        int n = A.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            while (i < j && A[i] < 0) {
                i++;
            }
            while (i < j && A[j] > 0) {
                j--;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        
        if (n % 2 == 0) {
            i = 1;
            j = n - 2;
        } else if (A[n / 2] < 0) {
            i = 1;
            j = n - 1;
        } else {
            i = 0;
            j = n - 2;
        }
       
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i = i + 2;
            j = j - 2;
        }
        
        return A;
        
   }
}

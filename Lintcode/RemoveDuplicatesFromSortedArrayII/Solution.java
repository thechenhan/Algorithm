public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] a) {
        int newLength = a.length;
        int i = 0;
        while (i < newLength - 2) {
            if (a[i] == a[i + 2]) {
                for (int j = i + 1; j < newLength - 1; j++) {
                    a[j] = a[j + 1];
                }
                newLength--;
            } else {
                i++;
            }
        }
        
        return newLength;
    }
}
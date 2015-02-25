public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] a) {
        int newLength = a.length;
        int i = 0;
        while (i < newLength - 1) {
            if (a[i] == a[i + 1]) {
                for (int k = i + 1; k < newLength - 1; k++) {
                        a[k] = a[k + 1];
                }
                newLength--;
            } else {
                i++;
            }
        }
        return newLength;
    }
}

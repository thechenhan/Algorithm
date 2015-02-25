public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[start] < num[mid]) {
                if (num[start] > num[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                    end = mid;
            }               
        }
        
        if (num[start] < num[end]) {
            return num[start];
        } else {
            return num[end];
        }
    }
}

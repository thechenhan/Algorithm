public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] m, int target) {
        if (m == null || m.length == 0) {
            return false;
        }
        
        int row = m.length;
        int col = m[0].length;
        int targetRow = 0;
        //find the row
        int start = 0;
        int end = row - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (m[mid][0] == target) {
                return true;
            } else if (m[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (target >= m[start][0]) {
            targetRow = start;
        } else {
            return false;
        }
        
        if (target >= m[end][0]) {
            targetRow = end;
        }
        
        //find the col
        start = 0;
        end = col - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (m[targetRow][mid] == target) {
                return true;
            } else if (m[targetRow][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (m[targetRow][start] == target || m[targetRow][end] == target) {
            return true;
        }
        
        return false;
    }
}
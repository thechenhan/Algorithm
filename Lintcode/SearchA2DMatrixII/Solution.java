public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
       public int searchMatrix(int[][] m, int target) {
        if (m == null || m.length == 0) {
            return 0;
        }
        
        if (m[0].length == 0) {
            return 0;
        }
        
        int row = m.length;
        int col = m[0].length;
        
        if (m[0][0] > target || m[row - 1][col - 1] < target) {
            return 0;
        }
        
        int i = row - 1;
        int j = 0;
        int ans = 0;
        while (i >= 0 && j <= col - 1) {
            if (m[i][j] == target) {
                i--;
                j++;
                ans++;
            } else if (m[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        
        return ans;
    }
    
}


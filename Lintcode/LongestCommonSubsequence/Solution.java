public class Solution {

    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }
        int lengthA = A.length();
        int lengthB = B.length();
        int[][] f = new int[lengthA + 1][lengthB + 1];
        for (int i = 1; i <= lengthA; i++) {
            for (int j = 1; j <= lengthB; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        
        return f[lengthA][lengthB];
        
    }

}
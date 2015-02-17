public class Solution {

    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] F = new int[n];
        for (int i = 0; i <= n - 1; i++) {
            F[i] = 1;
        }
        
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    F[i] = Math.max(F[i], F[j] + 1);
                }
            }
        }
        
        
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i <= n - 1; i++) {
            ans = Math.max(ans, F[i]);
        }
        return ans;
    }

}
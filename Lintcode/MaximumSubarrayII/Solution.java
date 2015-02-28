import java.util.*;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if (nums == null) {
            return 0;
        }
        
        int n = nums.size();
        
        if (n == 0) {
            return 0;
        }
        
        int[] sum = new int[n];
        sum[0] = nums.get(0);
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums.get(i);
        }
        
        int[] left = new int[n];
        left[0] = sum[0];
        int min = left[0];
        for (int i = 1; i < n; i++) {
            int temp = Math.max(sum[i], sum[i] - min);
            left[i] = Math.max(left[i - 1], temp);
            min = Math.min(min, sum[i]);
        }
        
        int[] right = new int[n];
        right[n - 1] = nums.get(n - 1);
        int max = sum[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - sum[i]);
            max = Math.max(max, sum[i]);
        }
        
        int ans = Integer.MIN_VALUE;
        
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, left[i] + right[i + 1]);
        }
        
        return ans;
        
    }
}



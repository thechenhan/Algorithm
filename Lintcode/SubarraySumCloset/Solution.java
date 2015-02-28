import java.util.*;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */

    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int[] sum = new int[n];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int prevSum = 0;
        for (int i = 0; i < n; i++) {
            sum[i] = prevSum + nums[i];
            prevSum = sum[i];
            if (map.containsKey(sum[i])) {
                ans.add(map.get(sum[i]) + 1);
                ans.add(i);
                return ans;
            } else if (sum[i] == 0) {
                ans.add(0);
                ans.add(i);
                return ans;
            } else {
                map.put(sum[i], i); 
            }
        }
        
        Arrays.sort(sum);
        int ansi = 0;
        int ansj = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            
            if (Math.abs(sum[i] - sum[i - 1]) < min) {
                min = Math.abs(sum[i] - sum[i - 1]);
                ansi = Math.min(map.get(sum[i - 1]), map.get(sum[i])) + 1;
                ansj = Math.max(map.get(sum[i - 1]), map.get(sum[i]));
            }
        }
        ans.add(ansi);
        ans.add(ansj);
        return ans;
    }
}
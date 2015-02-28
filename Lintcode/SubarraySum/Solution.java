import java.util.*;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        int n = nums.length;
       
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int prevSum = 0;
        for (int i = 0; i < n; i++) {
            sum = prevSum + nums[i];
            prevSum = sum;
            if (map.containsKey(sum)) {
                ans.add(map.get(sum) + 1);
                ans.add(i);
                return ans;
            } else if (sum == 0) {
                ans.add(0);
                ans.add(i);
                return ans;
            } else {
                map.put(sum, i); 
            }
        }
        
        return ans;
        
    }
}

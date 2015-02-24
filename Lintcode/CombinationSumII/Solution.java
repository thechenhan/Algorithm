import java.util.*;

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num == null) {
            return ans;
        }
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<Integer>();
        comSum2Helper(num, target, ans, list, 0);
        return ans;
    }
    
    
    public void comSum2Helper(int[] num, int target, List<List<Integer>> ans, 
    ArrayList<Integer> list, int pos) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = pos; i < num.length; i++) {
            if (i != pos && num[i] == num[i-1]) {
                continue;
            }
            if (num[i] > target) {
                continue;
            }
            list.add(num[i]);
            comSum2Helper(num, target - num[i], ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
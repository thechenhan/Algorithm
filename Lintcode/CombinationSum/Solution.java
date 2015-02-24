import java.util.*;

public class Solution {
       public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (target == 0 || candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        int pos = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        combSumHelper(ans, list, candidates, target, pos);
        return ans;
    }
    
    public void combSumHelper(List<List<Integer>> ans, ArrayList<Integer> list,
    int[] candidates, int target, int pos) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            list.add(candidates[i]);
            combSumHelper(ans, list, candidates, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
            
        }
    }

}
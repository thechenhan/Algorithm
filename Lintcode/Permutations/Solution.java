import java.util.*;

public class Solution {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (nums == null) {
            return ans;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int pos = 0;
        permuteHelper(nums, list, ans, pos);
        return ans;
    }
    
    //pos is the recursion depth
    public void permuteHelper(ArrayList<Integer> nums, ArrayList<Integer> list,
    ArrayList<ArrayList<Integer>> ans, int pos) {
        if (pos == nums.size()) {
            ans.add(new ArrayList<Integer>(list));
        }
        
        for (int i = 0; i < nums.size(); i++){
            if (!list.contains(nums.get(i))){
                list.add(nums.get(i));
                permuteHelper(nums, list, ans, pos + 1);
                list.remove(list.size() - 1);
            }
        } 
    }
}


import java.util.*;

public class Solution {
    
     public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (S == null) {
            return ans;
        }
        Collections.sort(S);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int pos = 0;
        uniqueSubsetsHelper(S, list, ans, pos);
        return ans;
    }
    
    public void uniqueSubsetsHelper(ArrayList<Integer> S, ArrayList<Integer> list,
    ArrayList<ArrayList<Integer>> ans, int pos) {
        ans.add(new ArrayList<Integer>(list));
       
        for (int i = pos; i < S.size(); i++) {
            if (i != pos && S.get(i) == S.get(i - 1)) {
                continue;
            }
            list.add(S.get(i));
            uniqueSubsetsHelper(S, list, ans, i + 1);
            list.remove(list.size() - 1);
            
        }
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Solution
{  /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        if (S == null){
            return null;
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        Collections.sort(S);
        solveHelper(ans, path, S, 0);
        return ans;
    }
   
   private static void solveHelper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> path, 
   ArrayList<Integer> S, int pos){
       ans.add(new ArrayList<Integer>(path));
       
       for (int i = pos; i < S.size(); i++){
           path.add(S.get(i));
           solveHelper(ans, path, S, i + 1);
           path.remove(path.size() - 1);
        }
    
   }
   
   public static void main(String args[]){
       ArrayList<Integer> S = new ArrayList(3);
       S.add(3);
       S.add(2);
       S.add(1);
       ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
       ans = subsets(S);
       int a = 1;
    }
}

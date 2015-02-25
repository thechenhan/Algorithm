import java.util.*;

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        
        while (i != A.size() && j != B.size()) {
            if (A.get(i) <= B.get(j)) {
                ans.add(A.get(i));
                i++;
            } else {
                ans.add(B.get(j));
                j++;
            }            
        }
        
        if (i == A.size()) {
            while (j < B.size()) {
               ans.add(B.get(j));
               j++;  
            }
        } else {
            while (i < A.size()) {
               ans.add(A.get(i));
               i++;
            }
        }
        
        return ans;
    }
}

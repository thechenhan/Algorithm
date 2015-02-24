import java.util.*;

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int findRangeA(ArrayList<Integer> A, int target) {
        int start = 0;
        int end = A.size() - 1;
       
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A.get(mid) == target) {
                end = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            } else if (A.get(mid) > target) {
                end = mid; 
            }
        }
        if (target == A.get(start)){
            return start;
        }
        if (target == A.get(end)){
            return end;
        }
        return -1;
    }
    
    public int findRangeB(ArrayList<Integer> A, int target) {
        int start = 0;
        int end = A.size() - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A.get(mid) == target) {
                start = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            } else if (A.get(mid) > target) {
                end = mid; 
            }
        }
        
        if (target == A.get(end)){
            return end;
        }
        
        if (target == A.get(start)){
            return start;
        }
        return -1;
    }
    
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (A == null || A.size() == 0) {
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        
        ans.add(findRangeA(A, target));
        ans.add(findRangeB(A, target));
        return ans;
    }
}

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
import java.util.*;

public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        searchHelper(ans, root, k1, k2);
        return ans;
    }
    
    private void searchHelper(ArrayList<Integer> ans, TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }
        
        if (root.val >= k1 && root.val <= k2) {
            //notice the inorder sequence. otherwise the result will be wrong;
            searchHelper(ans, root.left, k1, k2);
            ans.add(root.val);
            searchHelper(ans, root.right, k1, k2);
        } else if (root.val < k1) {
            searchHelper(ans, root.right, k1, k2);
        } else if (root.val > k2) {
            searchHelper(ans, root.left, k1, k2);
        }
    }
}
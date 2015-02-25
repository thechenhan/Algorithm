public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);
        
        long lval = Long.MIN_VALUE;
        long rval = Long.MAX_VALUE;
        
        if (root.right != null) {
            rval = root.right.val;
        }
        
        if (root.left != null) {
            lval = root.left.val;
        }
        
        if (lval < root.val && rval > root.val) {
            return left && right;
        }
        
        return false;
    }
}
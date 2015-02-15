public class Solution {

    public static TreeNode findNode(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
            return root;
        }
        
        TreeNode left = findNode(root.left, A, B);
        TreeNode right = findNode(root.right, A, B);
        
        if (left != null && right != null) {
            return root;
        }
        
        if (left != null) {
            return left;
        }
        
        if (right != null) {
            return right;
        }
                
        return null;
    }
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || A == null || B == null) {
            return null;
        }
        
        return findNode(root, A, B);       
    }

}
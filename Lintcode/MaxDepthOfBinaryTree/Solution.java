public class Solution {
    
    public static int MaxDepth(TreeNode root){
        int ans = 0;
        if (root == null) {
            return ans;
        }
        
        ans = Math.max(MaxDepth(root.left), MaxDepth(root.right)) + 1;
        return ans;
    
    }
  
}
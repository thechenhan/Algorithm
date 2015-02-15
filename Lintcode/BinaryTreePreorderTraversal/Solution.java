import java.util.ArrayList;
import java.util.Stack;

public class Solution
{
   //method 1, divide and conquer
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        if (root == null) {
            return ans;
        }
        
        ans.add(root.val);
        ans.addAll(preorderTraversal(root.right));
        ans.addAll(preorderTraversal(root.left));
        
        return ans;            
        
    }
   
    
   //method 2, iteration
   public static ArrayList<Integer> preorderTraversal2(TreeNode root) {
       ArrayList<Integer> ans = new ArrayList<Integer>();
       solvehelper(root, ans);
       return ans; 
   }
   
   private static void solvehelper(TreeNode root, ArrayList<Integer> ans){
      if (root == null) {
          return;
      }
      
      ans.add(root.val);
      solvehelper(root.left, ans);
      solvehelper(root.right, ans);     
   }
   
   
   
   //method 3, no iteration, use stack
   public static ArrayList<Integer> preorderTraversal3(TreeNode root) {
       ArrayList<Integer> ans = new ArrayList<Integer>();
       Stack<TreeNode> stack = new Stack<TreeNode>();
       if (root == null) {
            return ans;
       }
       
       stack.push(root);
       TreeNode tempNode = new TreeNode(0);
       while (!stack.empty()) {
           tempNode = stack.pop();
           ans.add(tempNode.val);
           if (tempNode.right != null) {
               stack.push(tempNode.right);
           }
          
           if (tempNode.left != null) {
               stack.push(tempNode.left);
           }
       }

       return ans;
   }
  
}

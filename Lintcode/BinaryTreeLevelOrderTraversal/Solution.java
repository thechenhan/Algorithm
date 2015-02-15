import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;


public class Solution {
    
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()){
            int sizeQ = queue.size();
            ArrayList<Integer> ansLevel = new ArrayList<Integer>();
            for (int i = 1; i <= sizeQ; i++){
                TreeNode head = queue.poll();
                ansLevel.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }              
            }
            ans.add(ansLevel);
        }
                
        return ans;
    }
        
    
    
    
    public static void main(String[] args) {
        
        for(int i = 1; i<= 10; i++){
            int a = 2;
            System.out.println(a);
        }
        
        
    }
}
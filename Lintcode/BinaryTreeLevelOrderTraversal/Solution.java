import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;


public class Solution {
    //order I
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
        
    //zigzig order
    
     public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        int direction = 1;
        while (!queue.isEmpty()){
            int sizeQ = queue.size();
            ArrayList<Integer> ansLevel = new ArrayList<Integer>();
            if (direction == 1) {
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
                direction = 2;
            } else {
                Stack<TreeNode> ansTemp = new Stack<TreeNode>();
                for (int i = 1; i <= sizeQ; i++){
                    TreeNode head = queue.poll();
                    ansTemp.push(head);
                    if (head.left != null) {
                        queue.offer(head.left);
                    }
                    if (head.right != null) {
                        queue.offer(head.right);
                    }              
                }
                while (!ansTemp.empty()) {
                    ansLevel.add(ansTemp.pop().val);
                }
                direction = 1;
            }
            
            ans.add(ansLevel);
        }
                
        return ans;
    }
    
    
}
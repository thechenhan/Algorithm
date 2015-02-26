public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return node;
        }
        
        TreeNode temp = root;
        while (true) {
            if (temp.right != null && node.val > temp.val) {
                temp = temp.right;
            } else if (temp.left != null && node.val < temp.val) {
                temp = temp.left;
            } else {
                break;
            }
        }
        
        if (node.val > temp.val) {
            temp.right = node;
        } else {
            temp.left = node;
        }
        
        return root;
    }
}
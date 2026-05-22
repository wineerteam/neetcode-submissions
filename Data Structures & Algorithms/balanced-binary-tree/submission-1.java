/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    
    public boolean isBalanced(TreeNode root) {
         if( root == null)
         return true;

        int a = height(root.left);
        int b = height(root.right);
        
        int diff = Math.abs(a-b);
        if( diff > 1) return false;
        
        boolean leftans= isBalanced(root.left);
        boolean rightans= isBalanced(root.right);


        return leftans && rightans;
        
        
    }
    static int height(TreeNode node){
        if( node == null )
        return 0;
        
        // move left side and find height
        int l =height(node.left);

        // move right side and find height
        int r =height(node.right);

        // find max 
        return 1+Math.max(l,r);
    }
}

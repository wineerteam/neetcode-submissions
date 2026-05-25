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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans =new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if( root == null)
        return ans;
        q.add(root);
       
        while( !q.isEmpty()){
            TreeNode temp1 = q.peek();
            ans.add(temp1.val);
            int size = q.size();
          while( size --> 0){
            TreeNode temp= q.remove();
             // move right side first
          if( temp.right != null)
          q.add(temp.right);
          // move left 
          if( temp.left != null)
          q.add(temp.left);

          }

         
        }

return ans;
    }
}

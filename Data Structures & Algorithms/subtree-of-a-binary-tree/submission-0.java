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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         

         if( root == null )
         return false;
     // if mathc one value then move then use identical conditions

      

        if( isIdentical(root,subRoot))
           return true;
       

        
     return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
       
    }

    static boolean isIdentical(TreeNode root, TreeNode subRoot){


        // both node have null so both identical
              if( root == null && subRoot == null)
              return true;

        // dono me se koi ek null or dusra nhi to fir wo same nhi ho skta
             if( root == null || subRoot == null)
              return false;
              
              // node value same nhi to not identical
              if( root.val != subRoot.val)
              return false;

              return isIdentical(root.left,subRoot.left) && isIdentical(root.right,subRoot.right);
    }
}

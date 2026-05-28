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

    // int index = 0;
    Map<Integer,Integer> map=new HashMap<>();

    public TreeNode buildTree(int[] pre, int[] in) {
            int n = in.length;
            for( int i=0; i<n; i++){
                map.put(in[i],i);
            }
            // pre, in, InStart,InEnd,index(pre ka)
        return ans(pre,in,0,n-1,0);
        
    }
    public  TreeNode ans(int [] pre, int [] in, int InStart, int InEnd, int index){

         // base case jab InStart > InEnd
         if( InStart > InEnd){
            return null;
         }

         // crate root node
       TreeNode root = new TreeNode(pre[index]);

                     // in, target, start,end
         int pos = map.get(pre[index]);
        //  int pos = find(in,pre[index],InStart,InEnd);
         // move left
         root.left = ans(pre, in, InStart,pos-1,index+1);
         root.right= ans(pre, in, pos+1,InEnd,index+(pos-InStart)+1);
         return root;
    }
    // public  int find(int in [], int target, int start, int end){
    //     for( int i=start; i<=end; i++){
    //         if( in[i] == target){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

}

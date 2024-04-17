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
    String res="";
    
    public String sm(TreeNode root,String sum){
        if(root==null)
            return "";
        sum=(char)(root.val+97)+sum;
        if(root.left==null && root.right==null){
            //int q=Integer.parseInt(sum);
            if(res=="")
                res=sum;
            if(res.compareTo(sum)>0)
                res=sum;
        }
        sm(root.left,sum);
        sm(root.right,sum);
        return res;
    }
    public String smallestFromLeaf(TreeNode root) {
        return sm(root,"");
        
        
    }
}
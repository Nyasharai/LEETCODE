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
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return check(Integer.MIN_VALUE,Integer.MAX_VALUE,root);
//     }
//     public static boolean check(int min, int max, TreeNode root){
//         if(root == null){
//             return true;
//         }
//         if(root.val >= max || root.val <= min){
//             return false;
//         }
//         return check(min,root.val,root.left) && check(root.val,max,root.right);
//     }
// }

class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(null, null, root);
    }

    public static boolean check(Integer min, Integer max, TreeNode root) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        return check(min, root.val, root.left) && check(root.val, max, root.right);
    }
}



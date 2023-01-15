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
    public TreeNode BST(int[] nums, int s, int e) {
            if(s>e)  return null;
            int mid = (s+e)/2;
            TreeNode nn = new TreeNode(nums[mid]);
            nn.left = BST(nums,s,mid-1);
            nn.right = BST(nums,mid+1,e);
            return nn;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums,0,nums.length-1);
    }
}
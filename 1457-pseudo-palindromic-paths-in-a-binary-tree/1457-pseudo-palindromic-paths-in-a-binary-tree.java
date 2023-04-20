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
    int ans=0;
    public void paths(TreeNode root, int[] fre){
        if(root==null) return;
        fre[root.val]++;
        if(root.left==null && root.right==null){
            if(ispalindromepermutation(fre))
                ans++;
        }
        paths(root.left,fre);
        paths(root.right,fre);
        fre[root.val]--;
    }
    public boolean ispalindromepermutation(int[] fre){
        int odd=0;
        for(int ele : fre){
            if(ele%2!=0)
                odd++;
        }
        if(odd==0 || odd==1) return true;
        return false;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root==null) return 0;
        int[] fre = new int[10];
        paths(root,fre);
        return ans;
    }
}
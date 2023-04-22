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
    public int sum(TreeNode root, Map<Integer,Integer> hm){
        if(root==null) return 0;
        int left = sum(root.left,hm);
        int right = sum(root.right,hm);
        int ans = root.val+left+right;
        hm.put(ans,hm.getOrDefault(ans,0)+1);
        return ans;
    }
    public int postorder(TreeNode root, int max, Map<Integer,Integer> hm, Set<Integer> hs){
        if(root==null) return 0;
        int left = postorder(root.left,max,hm,hs);
        int right = postorder(root.right,max,hm,hs);
        int ans = root.val+left+right;
        if(hm.get(ans)==max) hs.add(ans);
        return ans;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> hm = new HashMap<>();
        sum(root,hm);
        int max = Integer.MIN_VALUE;
        for(int val : hm.values()){
            max = Math.max(max,val);
        }
        Set<Integer> hs = new HashSet<>();
        postorder(root,max,hm,hs);
        int[] arr = new int[hs.size()];
        int i=0;
        for(int ele : hs){
            arr[i++] = ele;
        }
        return arr;
    }
}
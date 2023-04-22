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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> hm = new HashMap<>();
        sum(root,hm);
        int max = Integer.MIN_VALUE;
        for(int val : hm.values()){
            max = Math.max(max,val);
        }
        List<Integer> al = new ArrayList<>();
        for(int key : hm.keySet()){
            if(hm.get(key)==max)
                al.add(key);
        }
        int[] arr = new int[al.size()];
        for(int i=0;i<al.size();i++){
            arr[i] = al.get(i);
        }
        return arr;
    }
}
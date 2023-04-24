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
    public int sort(ArrayList<Integer> al){
        int[] sorted = new int[al.size()];
        for(int i=0;i<al.size();i++){
            sorted[i] = al.get(i);
        }
        Arrays.sort(sorted);
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<al.size();i++){
            hm.put(al.get(i),i);
        }
        int count=0;
        for(int i=0;i<sorted.length;i++){
            int val = al.get(i);
            if(val!=sorted[i]){
                count++;
                int ind1 = hm.get(val);
                int ind2 = hm.get(sorted[i]);
                hm.put(val,ind2);
                hm.put(sorted[i],ind1);
                al.set(ind1,sorted[i]);
                al.set(ind2,val);
            }
        }
        return count;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans=0;
        while(q.size()>0){
            int size = q.size();
            ArrayList<Integer> al = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = q.remove();
                al.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            ans+=sort(al);
        }
        return ans;
    }
}
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hs1 = new HashSet<>();
        Set<Integer> hs2 = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            hs1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            hs2.add(nums2[i]);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i : hs1){
            if(hs2.contains(i))
                al.add(i);
        }
        int[] ans = new int[al.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = al.get(i);
        }
        return ans;
    }
}
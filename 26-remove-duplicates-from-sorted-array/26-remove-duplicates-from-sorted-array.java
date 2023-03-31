class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            if(nums[i]!=nums[i+1])
                al.add(nums[i]);
        }
        al.add(nums[n-1]);
        for(int i=0;i<al.size();i++){
            nums[i] = al.get(i);
        }
        return al.size();
    }
}
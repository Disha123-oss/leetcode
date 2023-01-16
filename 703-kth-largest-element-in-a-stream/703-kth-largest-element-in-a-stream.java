class KthLargest {
    int k;
    ArrayList<Integer> al = new ArrayList<>(); 
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i=0;i<nums.length;i++){
            al.add(nums[i]);
        }
    }
    
    public int add(int val) {
        al.add(val);
        Collections.sort(al);
        return al.get(al.size()-k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
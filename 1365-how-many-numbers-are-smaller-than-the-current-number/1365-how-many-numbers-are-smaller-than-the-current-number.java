class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<nums.length;i++){
            st.push(arr[i]);
        }
        Map<Integer,Integer> hm = new HashMap<>();
        while(st.size()>0){
            int num = st.pop();
            if(st.size()>0 && st.peek()<num){
                hm.put(num,st.size());
            }
            else if(st.size()==0)
                hm.put(num,0);
        }
        
        for(int i=0;i<nums.length;i++){
            nums[i] = hm.get(nums[i]);
        }
        return nums;
    }
}
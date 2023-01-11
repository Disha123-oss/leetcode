class Solution {
    public int maxWidthRamp(int[] nums) {
        int max=0;
        Stack<Integer> st = new Stack<>();
		for(int i=0;i<nums.length;i++){
            if(st.size()>0 && nums[i]<nums[st.peek()])
                st.push(i);
            else if(st.size()==0)
                st.push(i);
        }
        int j=nums.length-1;
        while(st.size()>0){
            if(st.size()>0 && nums[j]>=nums[st.peek()]){
                max=Math.max(max,j-st.peek());
                st.pop();
            }
            else
                j--;
        }
		return max;
    }
}
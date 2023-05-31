class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length, j=0, k=0;
        int[] list1 = new int[n/2];
        int[] list2 = new int[n/2];
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                list1[j++]=nums[i];
            }
            else{
                list2[k++]=nums[i];
            }
        }
        int[] ans = new int[n];
        int i=0;j=0;k=0;
        while(k<n){
            if(k%2==0){
                ans[k++]=list1[i++];
            }
            else{
                ans[k++]=list2[j++];
            }
        }
        return ans;
    }
}
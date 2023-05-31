class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, index=-1, max=-1, temp=-1;
        for(int i=n-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                index=i-1;
                break;
            }
        }
        if(index==-1){
            int s=0,e=n-1;
            while(s<e){
                temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
            return;
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[index]){
                max = i;
                break;
            }
        }
        temp = nums[index];
        nums[index] = nums[max];
        nums[max] = temp;
        int s=index+1, e=n-1;
        while(s<e){
            temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}
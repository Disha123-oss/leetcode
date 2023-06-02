class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length, cnt1=0, cnt2=0, ele1=Integer.MIN_VALUE, ele2=Integer.MIN_VALUE, max=n/3+1;
        List<Integer> al = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(cnt1==0 && nums[i]!=ele2){
                ele1=nums[i];
                cnt1=1;
            }
            else if(cnt2==0 && nums[i]!=ele1){
                ele2=nums[i];
                cnt2=1;
            }
            else if(nums[i]==ele1) cnt1++;
            else if(nums[i]==ele2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0; cnt2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele1) cnt1++;
            else if(nums[i]==ele2) cnt2++;
        }
        if(cnt1>=max) al.add(ele1);
        if(cnt2>=max) al.add(ele2);
        return al;
    }
}
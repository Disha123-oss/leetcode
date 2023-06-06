class Solution {
    public int maxProduct(int[] nums) {
        //whenever 0 will come i will update my product to 1
        //have to iterate in both directions
        int n = nums.length, pro=1, max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            pro*=nums[i];
            max = Math.max(max,pro);
            if(pro==0)
                pro=1;
        }
        pro=1;
        for(int i=n-1;i>=0;i--){
            pro*=nums[i];
            max = Math.max(max,pro);
            if(pro==0)
                pro=1;
        }
        return max;
    }
}
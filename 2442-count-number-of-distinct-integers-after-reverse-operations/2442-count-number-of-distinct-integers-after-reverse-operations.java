class Solution {
    public int reverse(int num){
        int dig,sum=0;
        while(num>0){
            dig=num%10;
            sum=sum*10+dig;
            num=num/10;
        }
        return sum;
    }
    public int countDistinctIntegers(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            al.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            al.add(reverse(nums[i]));
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<al.size();i++){
            hm.put(al.get(i),hm.getOrDefault(al.get(i),0)+1);
        }
        return hm.size();
    }
}
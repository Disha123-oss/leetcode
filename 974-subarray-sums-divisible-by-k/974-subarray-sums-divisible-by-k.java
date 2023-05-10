class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
         hm.put(0,1);
         int sum = 0, cnt = 0;
         for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int key = sum%k;
            if(key<0)
                key+=k;
            if(hm.containsKey(key))
                cnt+=hm.get(key);
            hm.put(key,hm.getOrDefault(key,0)+1);
         }
         return cnt;
    }
}
class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),i);
        }
        int max=0, prev=-1;
        List<Integer> al = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            max=Math.max(max,hm.get(s.charAt(i)));
            if(i==max){
                al.add(max-prev);
                prev=max;
            }
        }
        return al;
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>, List<String>> fmap = new HashMap<>();
		for(int l=0;l<strs.length;l++){
			String s = strs[l];
			Map<Character,Integer> hm = new HashMap<>();
			for(int i=0;i<s.length();i++)
				hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
			if(fmap.containsKey(hm)){
				List<String> al = fmap.get(hm);
				al.add(s);
			}
			else{
				List<String> al = new ArrayList<>();
				al.add(s);
				fmap.put(hm,al);
			}
		}
        List<List<String>> ll = new ArrayList<>();
		for(List<String> al : fmap.values()){
			ll.add(al);
		}
        return ll;
    }
}
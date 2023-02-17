class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] arr = new int[n];
        int c=0;
        Map<Integer,Integer> hm = new HashMap<>();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0;i<n;i++){
			hm.put(arr1[i],hm.getOrDefault(arr1[i],0)+1);
		}
		for(int i=0;i<m;i++){
			if(hm.containsKey(arr2[i])){
				for(int j=0;j<hm.get(arr2[i]);j++){
					arr[c++]=arr2[i];
				}
			}
			hm.remove(arr2[i]);
		}
		for(int key : hm.keySet()){
			for(int i=0;i<hm.get(key);i++){
				al.add(key);
			}
		}
		Collections.sort(al);
		for(int i=0;i<al.size();i++){
			arr[c++]=al.get(i);
		}
        return arr;
    }
}
class Solution {
    public void nextPermutation(int[] arr) {
        int n = arr.length, first=-1;
		if(n==1) return;
		for(int i=n-2;i>=0;i--){
			if(arr[i]<arr[i+1]){
				first = i;
				break;
			}
		}
		if(first==-1){
            int[] nums = new int[n];
            int j=0;
			for(int i=n-1;i>=0;i--){
                nums[j++] = arr[i];
            }
            for(int i=0;i<n;i++){
                arr[i] = nums[i];
            }
            return;
		}
		int min = arr[first], max = Integer.MAX_VALUE, second=-1;
		for(int i=first+1;i<n;i++){
			if(arr[i]>min && arr[i]<max){
				max = Math.min(max,arr[i]);
				second = i;
			}
		}
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
		Arrays.sort(arr,first+1,n);	
		return;
    }
}
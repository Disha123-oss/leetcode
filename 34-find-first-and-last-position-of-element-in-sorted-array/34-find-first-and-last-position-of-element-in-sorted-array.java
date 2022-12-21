class Solution {
    public static int leftmosttarget(int[] arr, int target, int n){
		int s=0, e=n-1, ans=-1;
		while(s<=e){
			int mid=(s+e)/2;
			if(arr[mid]==target){
				ans=mid;
				e=mid-1;
			}
			else if(arr[mid]<target)
				s=mid+1;
			else
				e=mid-1;
		}
		return ans;
	}
	public static int rightmosttarget(int[] arr, int target, int n){
		int s=0, e=n-1, ans=-1;
		while(s<=e){
			int mid=(s+e)/2;
			if(arr[mid]==target){
				ans=mid;
				s=mid+1;
			}
			else if(arr[mid]<target)
				s=mid+1;
			else
				e=mid-1;
		}
		return ans;
	}
    public int[] searchRange(int[] arr, int target) {
        int[] a = new int[2];
        int n=arr.length;
        a[0]=leftmosttarget(arr,target,n);
		a[1]=rightmosttarget(arr,target,n);
        return a;
    }
}
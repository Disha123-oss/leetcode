class Solution {
    public String smallestNumber(String pattern) {
        String res="";
		Stack<Integer> st = new Stack<>();
		int n = pattern.length();
		int count=1;
		for(int i=0;i<n;i++){
			char ch = pattern.charAt(i);
			if(ch=='D'){
				st.push(count);
				count++;
			}
			else{
				st.push(count);
				count++;
				while(st.size()>0){
					res+=st.peek()+"";
					st.pop();
				}
			}
		}
		st.push(count);
		while(st.size()>0){
			res+=st.peek()+"";
			st.pop();
		}
		return res;
    }
}
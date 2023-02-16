class Solution {
    public String minWindow(String s, String t) {
        int st=0,e=0,count=0, start=0,end=0, ans=Integer.MAX_VALUE, distinct=0;
		int[] tfre = new int[123];
		for(int i=0;i<t.length();i++){
			tfre[t.charAt(i)]++;
			if(tfre[t.charAt(i)] == 1)
				distinct++;
		}
		int[] sfre = new int[123];
		
		while(e<s.length()){
			//expansion
			sfre[s.charAt(e)]++;
			if(sfre[s.charAt(e)] == tfre[s.charAt(e)])
				count++;
			e++;

			//contraction
			while(st<e && count == distinct){
				if(ans>e-st){
                    ans = e-st;
                    start = st;
                    end = e;
                }
				if(sfre[s.charAt(st)] == tfre[s.charAt(st)])
					count--;
				sfre[s.charAt(st)]--;
				st++;
			}
		}
		String str = "";
		str += s.substring(start,end);
		if(ans==Integer.MAX_VALUE)
			return "";
		return str;
    }
}
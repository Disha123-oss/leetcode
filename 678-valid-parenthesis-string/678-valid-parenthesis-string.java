class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if(ch=='(')
				s1.push(i);
			else if(ch=='*')
				s2.push(i);
			else if(ch==')'){
				if(s1.size()>0)
					s1.pop();
				else if(s2.size()>0)
					s2.pop();
				else
					return false;
			}
		}
		while(s1.size()>0){
			if(s2.size()==0)
				return false;
			else if(s1.peek()<s2.peek()){
					s1.pop();
					s2.pop();
			}
			else
				return false;
		}
		return true;
    }
}
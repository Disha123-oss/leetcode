class Solution {
    public int maxDepth(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        int count=0, depth=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='(')
                count++;
            else if(ch[i]==')')
                count--;
            depth=Math.max(count,depth);
        }
        return depth;
    }
}
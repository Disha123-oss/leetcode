import java.math.BigInteger;
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        String s = "";
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<num.length;i++){
            s += num[i];
        }
        BigInteger a = new BigInteger(s);
        BigInteger b = BigInteger.valueOf(k);
        BigInteger c = a.add(b);
        String str = String.valueOf(c);
        for(int i=0;i<str.length();i++){
            al.add(str.charAt(i)-'0');
        }
        return al;
    }
}
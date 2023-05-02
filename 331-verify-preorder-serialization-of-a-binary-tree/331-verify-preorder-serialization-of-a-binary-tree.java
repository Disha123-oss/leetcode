class Solution {
    public boolean isValidSerialization(String preorder) {
        int v=1;
        String[] arr = preorder.split(",");
        for(int i=0;i<arr.length;i++){
            if(v==0) return false;
            if(!arr[i].equals("#")){
                v+=1;
            }
            else if(arr[i].equals("#")){
                v-=1;
            }
            
        }
        if(v==0)
            return true;
        return false;
    }
}
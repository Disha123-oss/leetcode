class Solution {
    public boolean canJump(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] visited = new boolean[nums.length];
        visited[0]=true;
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int temp = q.remove();
                if(temp==nums.length-1)  return true;
                for(int j=temp+1;j<=temp+nums[temp];j++){
                    if(j>=nums.length) break;
                    if(visited[j]==false){
                        q.add(j);
                        visited[j]=true;
                    }
                }
            }
        }
        return false;
    }
}
class Solution {
    public int minJumps(int[] arr) {
        Map<Integer,ArrayList<Integer>> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                ArrayList<Integer> oldlist = hm.get(arr[i]);
                oldlist.add(i);
                hm.put(arr[i],oldlist);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hm.put(arr[i],list);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        q.add(0);
        visited[0]=true;
        int level=0;
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int temp = q.remove();
                if(temp==arr.length-1)
                    return level;
                if(temp+1<arr.length && visited[temp+1]==false){
                    q.add(temp+1);
                    visited[temp+1]=true;
                }
                if( temp-1>=0 && visited[temp-1]==false){
                    q.add(temp-1);
                    visited[temp-1]=true;
                }
                if(hm.containsKey(arr[temp])){
                    for(int ele : hm.get(arr[temp])){
                        if(visited[ele]==false){
                            q.add(ele);
                            visited[ele]=true;
                        }
                    }
                }
                hm.remove(arr[temp]);
            }
            level++;
        }
        return level;
    }
}
class MyHashSet {
    private final int array_size = 100;
    List<List<Integer>> parentlist = new ArrayList<>(array_size);
    public MyHashSet() {
        for(int i=0;i<array_size;i++){
            parentlist.add(null);
        }
    }
    
    public void add(int key) {
        int index = key % array_size;
        List<Integer> childlist = parentlist.get(index);
        if(childlist==null){
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentlist.set(index,list);
        }
        else{
            if(!childlist.contains(key)){
                childlist.add(key);
            }
        }
    }
    
    public void remove(int key) {
        int index = key % array_size;
        List<Integer> childlist = parentlist.get(index);
        if(childlist!=null){
            childlist.remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int index = key % array_size;
        List<Integer> childlist = parentlist.get(index);
        return childlist!=null && childlist.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
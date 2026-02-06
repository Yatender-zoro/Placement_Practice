class LRUCache {
    int c;
    ArrayList<int[]> li;
    HashMap<Integer,Integer> map;
    public LRUCache(int capacity) {
        this.c = capacity;
        li = new ArrayList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            for(int i=0;i<li.size();i++){
                if(li.get(i)[0]==key){
                    int[] temp = li.remove(i);
                    li.add(temp);
                    return temp[1];
                }
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            for(int i=0;i<li.size();i++){
                if(li.get(i)[0]==key){
                    li.remove(i);
                    li.add(new int[]{key,value});  
                }
            }
        }
        else if(li.size()<c){
            li.add(new int[]{key,value});
            map.put(key,value);
        }
        else{
            int[] temp = li.remove(0);
            li.add(new int[]{key,value});
            map.remove(temp[0]);
            map.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
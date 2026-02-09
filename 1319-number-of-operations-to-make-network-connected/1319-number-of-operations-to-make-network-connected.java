class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        if(node == parent.get(node)) return node;
        int par = findUPar(parent.get(node));
        parent.set(node,par);
        return parent.get(node);

    }

    public boolean UnionBySize(int u,int v){
        int upu = findUPar(u);
        int upv = findUPar(v);

        if(upu==upv) return false;

        if(size.get(upu)>size.get(upv)){
            parent.set(upv,upu);
            size.set(upu,size.get(upu)+size.get(upv));
        }
        else{
            parent.set(upu,upv);
            size.set(upv,size.get(upu)+size.get(upv));
        }
        return true;
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        DisjointSet ds = new DisjointSet(n);

        int extra = 0;
        for(int[] x:connections){
            if(!ds.UnionBySize(x[0],x[1])){
                extra++;
            }
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<ds.parent.size();i++){
            set.add(ds.findUPar(i));
        }

        int req = set.size();
        if(req-1<=extra) return req-1;
        return -1;
    }


}
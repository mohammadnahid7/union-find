public class WeightedQuickUnion {
    private int[] id;
    private int[] sz;

    public WeightedQuickUnion(int arrayLength){
        id = new int[arrayLength];
        sz = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }
    public boolean isConnected(int a, int b){
        return root(a) == root(b);
    }

    private int root(int x){
        while(id[x] != x){
            x = id[x];
        }
        return x;
    }

    public void union(int a, int b){
        int i = root(a);
        int j = root(b);
        if (sz[j] > sz[i]){
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
    }
    public int[] getUnionArray(){
        return this.id;
    }
}

public class PathCompressedQuickUnion{
    private int[] id;

    public PathCompressedQuickUnion(int arrayLength){
        id = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++){
            id[i] = i;
        }
    }
    public boolean isConnected(int p, int q){
        return root(p) == root(q);
    }

    private int root(int i){
        while(id[i] != i){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}

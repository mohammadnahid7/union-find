public class QuickUnion{
    private int[] id;

    public QuickUnion(int arrayLength){
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

public class QuickUnion implements Operation{
    private int[] id;

    public QuickUnion(int arrayLength){
        id = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++){
            id[i] = i;
        }
    }
    public boolean isConnected(int a, int b){
        return root(a) == root(b);
    }

    private int root(int i){
        while(id[i] != i){
            i = id[i];
        }
        return i;
    }

    public void union(int a, int b){
        int i = root(a);
        int j = root(b);
        id[i] = j;
    }
    public int[] getUnionArray(){
        return this.id;
    }
}

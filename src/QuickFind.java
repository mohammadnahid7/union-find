public class QuickFind{
    private int[] id;

    public QuickFind(int arrayLength){
        id = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++){
            id[i] = i;
        }
    }
    public boolean isConnected(int p, int q){
        return id[p] == id[q];
    }

    public void union(int p, int q){
        int aId = id[p];
        int bId = id[q];
        for(int i = 0; i < id.length; i++){
            if(id[i] == aId) id[i] = bId;
        }
    }
}

public class QuickFind {
    private int[] id;

    public QuickFind(int arrayLength){
        id = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++){
            id[i] = i;
        }
    }
    public boolean isConnected(int a, int b){
        return id[a] == id[b];
    }

    public void union(int a, int b){
        int aId = id[a];
        int bId = id[b];
        for(int i = 0; i < id.length; i++){
            if(id[i] == aId) id[i] = bId;
        }
    }
    public int[] getUnionArray(){
        return this.id;
    }
}

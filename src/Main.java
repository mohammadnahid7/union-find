public class Main {
    static final String _TINYUF = "tinyUF";
    static final String _MEDIUMUF = "mediumUF";
    static final String _LARGEUF = "largeUF";

    public static void main(String[] args){

        String[] tinyUFCommands = new ReadFile("tinyUF.txt").getAllCommands();
        String[] mediumUFCommands = new ReadFile("mediumUF.txt").getAllCommands();
        String[] largeUFCommands = new ReadFile("largeUF.txt").getAllCommands();

//        All operation on tinyUF.txt file
        quickFindOperation(tinyUFCommands, _TINYUF);
        quickUnionOperation(tinyUFCommands, _TINYUF);
        weightedQuickUnionOperation(tinyUFCommands, _TINYUF);
        pathCompressedQuickUnionOperation(tinyUFCommands, _TINYUF);
        pathCompressedWeightedOperation(tinyUFCommands, _TINYUF);

        System.out.println(" ");

//        All operation on mediumUF.txt file
        quickFindOperation(mediumUFCommands, _MEDIUMUF);
        quickUnionOperation(mediumUFCommands, _MEDIUMUF);
        weightedQuickUnionOperation(mediumUFCommands, _MEDIUMUF);
        pathCompressedQuickUnionOperation(mediumUFCommands, _MEDIUMUF);
        pathCompressedWeightedOperation(mediumUFCommands, _MEDIUMUF);

        System.out.println(" ");
//        All operation on largeUF.txt file
        weightedQuickUnionOperation(largeUFCommands, _LARGEUF);
        pathCompressedQuickUnionOperation(largeUFCommands, _LARGEUF);
        pathCompressedWeightedOperation(largeUFCommands, _LARGEUF);


    }


    // This function takes commands as input and do Quick Find operation only
    private static void quickFindOperation(String[] allCommandsArr, String fileName){
        int qfObjsLen = Integer.parseInt(allCommandsArr[0]);
        QuickFind quickFind = new QuickFind(qfObjsLen);

        int allCommandsArrLen = allCommandsArr.length - 1;

        // Operation Block - Timer start
        long startTime = System.nanoTime();
        for (int i = 1; i < allCommandsArrLen; i++){
            String[] itemArr = allCommandsArr[i].trim().split("\\s", -1);
            int a = Integer.parseInt(itemArr[0]);
            int b = Integer.parseInt(itemArr[1]);
            quickFind.union(a, b);
        }
        long endTime = System.nanoTime();
        // Operation Block - Timer end

        resultPrint(fileName, "Quick Find" , endTime-startTime);
    }

    // This function takes commands as input and do Quick Find operation only
    private static void quickUnionOperation(String[] allCommandsArr, String fileName){
        int quObjsLen = Integer.parseInt(allCommandsArr[0]);
        QuickUnion quickUnion = new QuickUnion(quObjsLen);

        int allCommandsArrLen = allCommandsArr.length - 1;

        // Operation Block - Timer start
        long startTime = System.nanoTime();
        for (int i = 1; i < allCommandsArrLen; i++){
            String[] itemArr = allCommandsArr[i].trim().split("\\s", -1);
            int a = Integer.parseInt(itemArr[0]);
            int b = Integer.parseInt(itemArr[1]);
            quickUnion.union(a, b);
        }
        long endTime = System.nanoTime();
        // Operation Block - Timer end

        resultPrint(fileName, "Quick Union", endTime-startTime);
    }

    private static void weightedQuickUnionOperation(String[] allCommandsArr, String fileName){
        int wqfObjsLen = Integer.parseInt(allCommandsArr[0]);
        WeightedQuickUnion weightedQuickUnion= new WeightedQuickUnion(wqfObjsLen);

        int allCommandsArrLen = allCommandsArr.length - 1;

        // Operation Block - Timer start
        long startTime = System.nanoTime();
        for (int i = 1; i < allCommandsArrLen; i++){
            String[] itemArr = allCommandsArr[i].trim().split("\\s", -1);
            int a = Integer.parseInt(itemArr[0]);
            int b = Integer.parseInt(itemArr[1]);
            weightedQuickUnion.union(a, b);
        }
        long endTime = System.nanoTime();
        // Operation Block - Timer end

        resultPrint(fileName, "Weighted Quick Union" , endTime-startTime );
    }


    private static void pathCompressedQuickUnionOperation(String[] allCommandsArr, String fileName){
        int pcquObjsLen = Integer.parseInt(allCommandsArr[0]);
        PathCompressedQuickUnion pathCompressedQuickUnion = new PathCompressedQuickUnion(pcquObjsLen);

        int allCommandsArrLen = allCommandsArr.length - 1;

        // Operation Block - Timer start
        long startTime = System.nanoTime();
        for (int i = 1; i < allCommandsArrLen; i++){
            String[] itemArr = allCommandsArr[i].trim().split("\\s", -1);
            int a = Integer.parseInt(itemArr[0]);
            int b = Integer.parseInt(itemArr[1]);
            pathCompressedQuickUnion.union(a, b);
        }
        long endTime = System.nanoTime();
        // Operation Block - Timer end

        resultPrint(fileName, "Path Compressed Quick Union" , endTime-startTime );
    }

    private static void pathCompressedWeightedOperation(String[] allCommandsArr, String fileName){
        int pcwObjsLen = Integer.parseInt(allCommandsArr[0]);
        PathCompressionWeighted pathCompressionWeighted = new PathCompressionWeighted(pcwObjsLen);

        int allCommandsArrLen = allCommandsArr.length - 1;

        // Operation Block - Timer start
        long startTime = System.nanoTime();
        for (int i = 1; i < allCommandsArrLen; i++){
            String[] itemArr = allCommandsArr[i].trim().split("\\s", -1);
            int a = Integer.parseInt(itemArr[0]);
            int b = Integer.parseInt(itemArr[1]);
            pathCompressionWeighted.union(a, b);
        }
        long endTime = System.nanoTime();
        // Operation Block - Timer end

        resultPrint(fileName, "Path Compressed Weighted" , endTime-startTime );
    }

    // Function to print result
    private static void resultPrint(String fileName, String operationName, long elapsedTime){
        System.out.println(fileName + "\t=>\t" + operationName + "\t=>\t" + (elapsedTime / 1_000_000) + " milliseconds");
    }
}
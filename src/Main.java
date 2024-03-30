import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] tinyUfCommands;
        String[] mediumUfCommands;
        String[] largeUfCommands;

        tinyUfCommands = fileRead("tinyUF.txt");
        mediumUfCommands = fileRead("mediumUF.txt");
        largeUfCommands = fileRead("largeUF.txt");


//        All algorithms on tinyUF file
        quickFind(tinyUfCommands, "tinyUF");
        quickUnion(tinyUfCommands, "tinyUF");
        weighted(tinyUfCommands, "tinyUF");
        pathCompressed(tinyUfCommands, "tinyUF");
        weightedPathCompressed(tinyUfCommands, "tinyUF");

        System.out.println(" ");

//        All algorithms on mediumUF file
        quickFind(mediumUfCommands, "mediumUF");
        quickUnion(mediumUfCommands, "mediumUF");
        weighted(mediumUfCommands, "mediumUF");
        pathCompressed(mediumUfCommands, "mediumUF");
        weightedPathCompressed(mediumUfCommands, "mediumUF");

        System.out.println(" ");

//        All algorithms on largeUF file
        weighted(largeUfCommands, "largeUF");
        pathCompressed(largeUfCommands, "largeUF");
        weightedPathCompressed(largeUfCommands, "largeUF");


        

    }


    private static String[] fileRead(String fileName) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("src/" + fileName));
        String content = new String(bytes);
        return content.split("\n", -1);
    }

    private static void quickFind(String[] commands, String operationFileName) {
        int qfObjsLen = Integer.parseInt(commands[0]);
        QuickFind quickFind = new QuickFind(qfObjsLen);
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < commands.length - 1; i++){
            String[] singleCommand = commands[i].trim().split("\\s", -1);
            int p = Integer.parseInt(singleCommand[0]);
            int q = Integer.parseInt(singleCommand[1]);
            quickFind.union(p,q);
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Quick Find on " + operationFileName + ": " + duration + " Millisecond");
    }
    private static void quickUnion(String[] commands, String operationFileName) {
        int qfObjsLen = Integer.parseInt(commands[0]);
        QuickUnion quickFind = new QuickUnion(qfObjsLen);
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < commands.length - 1; i++){
            String[] singleCommand = commands[i].trim().split("\\s", -1);
            int p = Integer.parseInt(singleCommand[0]);
            int q = Integer.parseInt(singleCommand[1]);
            quickFind.union(p,q);
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Quick Union on " + operationFileName + ": " + duration + " Millisecond");
    }
    private static void weighted(String[] commands, String operationFileName) {
        int qfObjsLen = Integer.parseInt(commands[0]);
        WeightedQuickUnion quickFind = new WeightedQuickUnion(qfObjsLen);
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < commands.length - 1; i++){
            String[] singleCommand = commands[i].trim().split("\\s", -1);
            int p = Integer.parseInt(singleCommand[0]);
            int q = Integer.parseInt(singleCommand[1]);
            quickFind.union(p,q);
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Weighted Quick Union on " + operationFileName + ": " + duration + " Millisecond");
    }
    private static void pathCompressed(String[] commands, String operationFileName) {
        int qfObjsLen = Integer.parseInt(commands[0]);
        PathCompressedQuickUnion quickFind = new PathCompressedQuickUnion(qfObjsLen);
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < commands.length - 1; i++){
            String[] singleCommand = commands[i].trim().split("\\s", -1);
            int p = Integer.parseInt(singleCommand[0]);
            int q = Integer.parseInt(singleCommand[1]);
            quickFind.union(p,q);
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Path Compressed Quick Union on " + operationFileName + ": " + duration + " Millisecond");
    }
    private static void weightedPathCompressed(String[] commands, String operationFileName) {
        int qfObjsLen = Integer.parseInt(commands[0]);
        PathCompressionWeighted quickFind = new PathCompressionWeighted(qfObjsLen);
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < commands.length - 1; i++){
            String[] singleCommand = commands[i].trim().split("\\s", -1);
            int p = Integer.parseInt(singleCommand[0]);
            int q = Integer.parseInt(singleCommand[1]);
            quickFind.union(p,q);
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Weighted Path Compressed Quick Union on " + operationFileName + ": " + duration + " Millisecond");
    }

}
import javax.management.ObjectInstance;
import java.util.Arrays;

public class Main {
    static final String _TINYUF = "tinyUF";
    static final String _MEDIUMUF = "mediumUF";
    static final String _LARGEUF = "largeUF";

    public static void main(String[] args){

        String[] tinyUFCommands = new ReadFile("tinyUF.txt").getAllCommands();
        String[] mediumUFCommands = new ReadFile("mediumUF.txt").getAllCommands();
        String[] largeUFCommands = new ReadFile("largeUF.txt").getAllCommands();

        operation(tinyUFCommands, _TINYUF);
        operation(mediumUFCommands, _MEDIUMUF);
        operation(largeUFCommands, _LARGEUF);


    }


    /* This function is responsible for executing all union find algorithms variations for one put file.
    * This function takes all the union commands as an array to execute union commands on various algorithm methods and
    * takes file name of the currently running file of operation to print with result on the screen as parameter.
    * We named 5 algorithms as follows
    *       0. QuickFind
    *       1. QuickUnion
    *       2. WeightedQuickUnion
    *       3. PathCompressedQuickUnion
    *       4. PathCompressionWeighted
    *
    * For one file, we need to run those 5 algorithms. So for each function call, function takes the commands from file,
    * loops from 0-4 (0 number algorithm to 4 number algorithm) and apply those union commands and print result. */
    private static void operation(String[] allCommandsArr, String fileName){
        System.out.println(" ");

        /* Since we have 5 algorithms for every file, looping 5 times for one file input */
        for (int i = 0; i < 5; i++){

            // if the file is largeUF, ignore first 2 algorithms
            if (fileName.equals(_LARGEUF) && i < 2){continue;}

            // Creating operation variable of Operation interface. This will help us to initiate various class objects
            Operation operation;

            /* As we named 5 algorithms from 0 to 4, this if else block will initiate Class object according to the name.
            Operation variable class object assignment depends on the current position of the loop. */
            if (i == 0){operation = new QuickFind(Integer.parseInt(allCommandsArr[0]));}
            else if (i == 1){operation = new QuickUnion(Integer.parseInt(allCommandsArr[0]));}
            else if (i == 2){operation = new WeightedQuickUnion(Integer.parseInt(allCommandsArr[0]));}
            else if (i == 3){operation = new PathCompressedQuickUnion(Integer.parseInt(allCommandsArr[0]));}
            else {operation = new PathCompressionWeighted(Integer.parseInt(allCommandsArr[0]));}


            // Getting the length of the commands array of the input file.
            int allCommandsArrLen = allCommandsArr.length - 1;

            // This block of code will loop through all the union commands of the input file and also calculate the total operation time.
            // Operation Block - Timer start
            long startTime = System.nanoTime();
            for (int j = 1; j < allCommandsArrLen; j++){
                String[] itemArr = allCommandsArr[j].trim().split("\\s", -1);
                int a = Integer.parseInt(itemArr[0]);
                int b = Integer.parseInt(itemArr[1]);
                operation.union(a, b);
            }
            long endTime = System.nanoTime();
            // Operation Block - Timer end

            // Print result with formatting
            resultPrint(fileName, operation.getClass().getName() , endTime-startTime);


        }

    }

    // Function to print result
    private static void resultPrint(String fileName, String operationName, long elapsedTime){
        System.out.println(fileName + "\t=>\t" + operationName + "\t=>\t" + String.format("%.3f",elapsedTime / 1_000_000_000.0) + " seconds");
    }
}
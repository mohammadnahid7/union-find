import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ReadFile {
    String[] allCommandsArr;

    public ReadFile(String fileName){
        File file = new File("src/" + fileName);
        try {
            /* This Files.readString() gets all content from text file at once and convert them
             an array of union commands instead of line by line reading and do union operation */

            this.allCommandsArr = Files.readString(file.toPath()).split("\\n", -1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String[] getAllCommands(){
        return allCommandsArr;
    }
}

package FileIntializer;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileContainer {
    private BufferedReader br;
    private FileReader fr;

    public FileContainer(BufferedReader aBufferedReader, FileReader aFileReader) {
        br = aBufferedReader;
        fr = aFileReader;
    }

    public BufferedReader getBufferedReader() {
        return br;
    }

    public FileReader getFileReader() {
        return fr;
    }
}

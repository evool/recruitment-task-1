import java.io.File;
import java.io.IOException;

public class Main {

    public static final int SCAN_INTERVAL = 3000;

    public static void main(String[] args) throws IOException, InterruptedException {
        new File(".\\home").mkdir();
        new File(".\\dev").mkdir();
        new File(".\\test").mkdir();
        new DirScanner(SCAN_INTERVAL);
    }
}

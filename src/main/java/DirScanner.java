import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;

public final class DirScanner {

    private File counterFile = null;

    public DirScanner(int interval) {
        try {
            String counterPath = ".\\home\\count.txt";
            counterFile = new File(counterPath);
            if(counterFile.createNewFile()) {
                writeToFile(0);
            }

            while (true) {
                Set<File> scannedFiles = FileUtils.listFiles(".\\home\\");
                System.out.println(scannedFiles);
                for(File file : scannedFiles) {
                    Optional<String> extension = FileUtils.getExtension(file);
                    if(extension.isPresent()) {
                        switch (extension.get()) {
                            case "jar":
                                if(FileUtils.isCreationHourEven(file)) {
                                    Files.move(file.toPath(), Paths.get(".\\dev\\" + file.getName()));
                                } else {
                                    Files.move(file.toPath(), Paths.get(".\\test\\" + file.getName()));
                                }
                                incrementCounter();
                                break;

                            case "xml":
                                Files.move(file.toPath(), Paths.get(".\\dev\\" + file.getName()));
                                incrementCounter();
                                break;
                        }
                    }
                }
                Thread.sleep(interval);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(int value) throws IOException {
        FileWriter fileWriter = new FileWriter(counterFile);
        fileWriter.write(Integer.toString(value));
        fileWriter.close();
    }

    private int readFromFile() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(counterFile));
        int readData = Integer.parseInt(fileReader.readLine());
        fileReader.close();
        return readData;
    }

    private void incrementCounter() throws IOException {
        writeToFile(readFromFile() + 1);
    }

}

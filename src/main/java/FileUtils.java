import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class FileUtils {

    public static Set<File> listFiles(String dir) throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::toFile)
                    .collect(Collectors.toSet());
        }
    }

    public static Optional<String> getExtension(File file) {
        return Optional.ofNullable(file.getName())
                .filter(f -> f.contains("."))
                .map(f -> f.substring(file.getName().lastIndexOf(".") + 1));
    }

    public static boolean isCreationHourEven(File file) throws IOException {
        FileTime creationTime = (FileTime) Files.getAttribute(file.toPath(), "creationTime");
        return creationTime.toMillis() % 2 == 0;
    }
}

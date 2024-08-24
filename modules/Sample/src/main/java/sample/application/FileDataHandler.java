package sample.application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileDataHandler {

    private final String basePath;

    public FileDataHandler(String basePath) {
        this.basePath = basePath;
    }

    public String readFileData(String filename) throws IOException {
        Path filePath = Paths.get(basePath, filename);
        if (Files.exists(filePath)) {
            return Files.lines(filePath).collect(Collectors.joining("\n"));
        } else {
            throw new IOException("File not found: " + filename);
        }
    }
}

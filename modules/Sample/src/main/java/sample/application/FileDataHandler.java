package sample.application;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileDataHandler {

    private final String basePath;
    private final ObjectMapper objectMapper;

    public FileDataHandler(String basePath) {
        this.basePath = basePath;
        this.objectMapper = new ObjectMapper();
    }

    public String readFileDataAsJson(String filename) throws IOException {
        Path filePath = Paths.get(basePath, filename);
        if (Files.exists(filePath)) {
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);

            // convert data to JSON
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("filename", filename);
            dataMap.put("lines", lines);

            return objectMapper.writeValueAsString(dataMap);
        } else {
            throw new IOException("File not found: " + filename);
        }
    }
}
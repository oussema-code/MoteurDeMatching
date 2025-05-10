import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class LocalCSVDataImporter implements DataImporter {
    private String filePath;

    public LocalCSVDataImporter(String filePath) {
        this.filePath = filePath;
    }
    public List<Nom> ImportData() {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines.skip(1) // Skip the header line
                    .map(line -> line.split(","))
                    .filter(values -> values.length >= 2)
                    .map(values -> new Nom(values[1].trim(), values[0].trim()))
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }

    }
}


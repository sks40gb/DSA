package lld.delete;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements Appender {
    private String fileName;

    public FileAppender(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void append(String message) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

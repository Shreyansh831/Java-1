import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileOperations {

    public static void main(String[] args) {
        String filePath = "example.txt";

        // Write to a file
        writeToFile(filePath, "Hello, World!\nThis is a sample text file.");

        // Read from the file
        readFromFile(filePath);

        // Modify the file
        modifyFile(filePath, "sample", "example");
        
        // Read the modified file
        readFromFile(filePath);
    }

    /**
     * Writes the given content to a specified file.
     *
     * @param filePath the path of the file to write to
     * @param content  the content to write to the file
     */
    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Content written to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Reads the content of a specified file and prints it to the console.
     *
     * @param filePath the path of the file to read from
     */
    public static void readFromFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            System.out.println("Content of the file:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    /**
     * Modifies the content of a specified file by replacing old text with new text.
     *
     * @param filePath the path of the file to modify
     * @param oldText  the text to be replaced
     * @param newText  the text to replace with
     */
    public static void modifyFile(String filePath, String oldText, String newText) {
        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            // Replace old text with new text
            for (int i = 0; i < lines.size(); i++) {
                lines.set(i, lines.get(i).replace(oldText, newText));
            }
            // Write the modified lines back to the file
            Files.write(Paths.get(filePath), lines);
            System.out.println("File modified: " + filePath);
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }
}

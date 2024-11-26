import java.io.*;
import javax.swing.*;

public class FileScan {
    public static void main(String[] args) {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        File file = null;


        if (args.length > 0) {
            file = new File(args[0]);
            System.out.println("File from command line: " + file.getAbsolutePath());
        } else {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select a file to scan");
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + file.getAbsolutePath());
            } else {
                System.out.println("No file selected");
                return;
            }
        }


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;  //
                charCount += line.length();
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nSummary Report:");
        System.out.println("File Name: " + file.getName());
        System.out.println("Number of Lines: " + lineCount);
        System.out.println("Number of Words: " + wordCount);
        System.out.println("Number of Characters: " + charCount);
    }
}

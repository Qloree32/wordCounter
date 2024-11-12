import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        Map<String, Integer> wordCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim().toLowerCase();
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        } catch (IOException e) {
            System.out.println("Error reading the input file: " + e.getMessage());
        }

        List<Map.Entry<String, Integer>> sortedWordCounts = new ArrayList<>(wordCounts.entrySet());
        sortedWordCounts.sort(Map.Entry.comparingByKey());
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : sortedWordCounts) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to the output file: " + e.getMessage());
        }
        
        System.out.println("Word count has been written to " + outputFile);
    }
}

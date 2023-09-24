import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String inputText = scanner.nextLine();

        // Convert the input text to lowercase and remove punctuation marks
        String cleanedText = cleanText(inputText);

        System.out.println("Number of words in the text: " + countWords(cleanedText));
        System.out.println("Number of unique words in the text: " + countUniqueWords(cleanedText));

        Map<String, Integer> wordFrequencyMap = calculateWordFrequency(cleanedText);
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static int countWords(String text) {
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static int countUniqueWords(String text) {
        String[] words = text.split("\\s+");
        Map<String, Integer> uniqueWordsMap = new HashMap<>();

        for (String word : words) {
            uniqueWordsMap.put(word, uniqueWordsMap.getOrDefault(word, 0) + 1);
        }

        return uniqueWordsMap.size();
    }

    public static Map<String, Integer> calculateWordFrequency(String text) {
        String[] words = text.split("\\s+");
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        return wordFrequencyMap;
    }

    public static String cleanText(String text) {
        // Convert to lowercase
        String cleanedText = text.toLowerCase();
        // Remove punctuation marks (except for apostrophes in words like "can't")
        cleanedText = cleanedText.replaceAll("[^a-zA-Z\\s'’]", "");
        return cleanedText;
    }
}

import java.util.HashMap;
import java.util.Scanner;

public class task2 {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();

        String[] words = text.split("[\\p{Punct}\\s]+");
        int count = words.length;

        System.out.println("Total number of words: " + count);

        // Ignore common words or stop words
        String[] stopWords = {"a", "an", "the", "and", "or", "but", "to", "of", "in", "for", "on"};
        HashMap<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            if (!contains(stopWords, word)) {
                wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
            }
        }

        // Display the frequency of each word
        System.out.println("Frequency of each word:");
        for (String word : wordFreq.keySet()) {
            System.out.println(word + ": " + wordFreq.get(word));
        }
    }

    public static boolean contains(String[] arr, String target) {
        for (String s : arr) {
            if (s.equals(target)) {
                return true;
            }
        }
        return false;

    }
}

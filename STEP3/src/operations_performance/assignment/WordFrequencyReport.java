package operations_performance.assignment;

import java.util.*;

public class WordFrequencyReport {

    static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        HashSet<String> stopSet = new HashSet<>();

        for (String word : stopWords) {
            stopSet.add(word);
        }

        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            if (stopSet.contains(word)) {
                continue;
            }

            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}
package name;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class SecondMostRepeatedWord {
    public static void main(String[] args) {
        String text = """
            apple banana apple orange banana apple mango banana orange mango mango
        """;
        List<String> words = Arrays.stream(text.toLowerCase().split("\\W+"))
                                   .filter(w -> !w.isBlank())
                                   .collect(Collectors.toList());
        Map<String, Long> frequencyMap = words.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Map.Entry<String, Long>> sortedByFrequency = frequencyMap.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toList());

        if (sortedByFrequency.size() < 2) {
            System.out.println("Not enough distinct words to find second most repeated word.");
        } else {
            Map.Entry<String, Long> secondMost = sortedByFrequency.get(1);
            System.out.println("Second most repeated word: " + secondMost.getKey() +
                               " -> " + secondMost.getValue() + " times");
        }
    }
}


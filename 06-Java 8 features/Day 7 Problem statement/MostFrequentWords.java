package name;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class MostFrequentWords {
    public static void main(String[] args) {
        String text = """
            In the heart of the city, the people gathered to celebrate the festival.
            The streets were decorated with lights and joy filled the air.
            Children laughed, music played, and everyone joined the celebration.
            The spirit of togetherness made the night unforgettable.
            """;

        int topN = 5;
        List<String> words = Arrays.stream(text.toLowerCase().split("\\W+"))
                                   .filter(w -> !w.isBlank())
                                   .collect(Collectors.toList());

        Map<String, Long> frequencyMap = words.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Top " + topN + " most frequent words:");
        frequencyMap.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
            .limit(topN)
            .forEach(entry ->
                System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}


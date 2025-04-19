import java.lang.*;
import java.util.*;
public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);
        Map<Integer, List<String>> invertedMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        System.out.println("Inverted Map:");
        for (Map.Entry<Integer, List<String>> entry : invertedMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}


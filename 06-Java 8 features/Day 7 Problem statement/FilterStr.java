package name;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class FilterStr {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Apple", "Banana", "Avocado", "Mango", "Apricot", "Berry");

        List<String> filtered = strings.stream()
                                       .filter(s -> !s.startsWith("A"))
                                       .collect(Collectors.toList());
        System.out.println("Filtered list (excluding strings starting with 'A'):");
        System.out.println(filtered);
    }
}


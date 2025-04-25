package name;
import java.util.*;
import java.util.function.Consumer;
public class ConsumerInterfaceProblem {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        Consumer<String> printInUppercase = s -> System.out.println(s.toUpperCase());
        strings.forEach(printInUppercase);
    }
}

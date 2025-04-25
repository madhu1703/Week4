package name;
import java.util.*;
import java.util.Optional;
public class OptionalMaxValue {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 50, 30, 40);
        Optional<Integer> maxValue = numbers.stream()
                                            .max(Integer::compareTo);
        maxValue.ifPresentOrElse(
            value -> System.out.println("Maximum value: " + value),
            () -> System.out.println("The list is empty, no maximum value.")
        );
    }
}
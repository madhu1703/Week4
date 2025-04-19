import java.lang.*;
import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4));
        List<Integer> result = removeDuplicates(input);
        System.out.println(result);
    }
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new LinkedHashSet<>();
        seen.addAll(list);
        return new ArrayList<>(seen);
    }
}


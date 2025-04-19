import java.lang.*;
import java.util.*;
public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int k = 2;
        rotateLeft(list, k);
        System.out.println(list);
    }
    public static void rotateLeft(List<Integer> list, int k) {
        int n = list.size();
        k = k % n;
        List<Integer> first = new ArrayList<>(list.subList(0, k));
        List<Integer> second = new ArrayList<>(list.subList(k, n));
        list.clear();
        list.addAll(second);
        list.addAll(first);
    }
}

import java.lang.*;
import java.util.*;
class Reversal
{
    public static <T> List<T> reversedAL(List<T> list) {
        List<T> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }
    public static <T> List<T> reversedLL(LinkedList<T> list)
    {
        LinkedList<T> reversed=new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }
    public static void main(String[] args)
    {
        List<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println("Original ArrayList: " + arrayList);
        System.out.println("Reversed ArrayList: " + reversedAL(arrayList));
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println("Original LinkedList: " + linkedList);
        System.out.println("Reversed LinkedList: " + reversedLL(linkedList));
    }
}
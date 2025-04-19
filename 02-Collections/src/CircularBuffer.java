import java.lang.*;
import java.util.*;
public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int start;
    private int end;
    private int count;
    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
        start = 0;
        end = 0;
        count = 0;
    }
    public void insert(int value) {
        buffer[end] = value;
        end = (end + 1) % size;

        if (count < size) {
            count++;
        } else {
            start = (start + 1) % size;
        }
    }
    public void printBuffer() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            int index = (start + i) % size;
            System.out.print(buffer[index]);
            if (i < count - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.printBuffer();
        cb.insert(4);
        cb.printBuffer();
        cb.insert(5);
        cb.printBuffer();
    }
}


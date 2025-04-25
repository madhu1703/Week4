package name;
import java.util.*;
class WorkerDetails {
    private String name;
    private int age;
    private double salary;
    public WorkerDetails(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    @Override
    public String toString() {
        return name + " - Age: " + age + ", Salary: " + salary;
    }
}
public class SortByAge {
    public static void main(String[] args) {
        List<WorkerDetails> workers = Arrays.asList(
            new WorkerDetails("Alice", 30, 50000),
            new WorkerDetails("Bob", 25, 45000),
            new WorkerDetails("Charlie", 35, 60000),
            new WorkerDetails("David", 28, 47000)
        );
        workers.sort((w1, w2) -> Integer.compare(w1.getAge(), w2.getAge()));
        System.out.println("Sorted list by age (ascending):");
        workers.forEach(System.out::println);
    }
}

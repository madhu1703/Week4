package name;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return id + " - " + name + " - " + department + " - $" + salary;
    }
}

public class EmployeeDataProcessor {

    public static void processEmployees(List<Employee> employees) {
        List<Employee> filtered = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("Engineering") && e.getSalary() > 80000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()) 
                .collect(toList());
        Map<String, List<Employee>> grouped = filtered.stream()
                .collect(groupingBy(Employee::getDepartment));
        Map<String, Double> averageSalary = grouped.entrySet().stream()
                .collect(toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(0.0)
                ));
        grouped.forEach((dept, empList) -> {
            System.out.println("Department: " + dept);
            empList.forEach(System.out::println);
            System.out.printf("Average Salary: $%.2f\n\n", averageSalary.get(dept));
        });
    }
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "Engineering", 90000),
            new Employee(2, "Bob", "Engineering", 85000),
            new Employee(3, "Charlie", "HR", 70000),
            new Employee(4, "David", "Engineering", 78000),
            new Employee(5, "Eve", "Sales", 82000)
        );

        processEmployees(employees);
    }
}


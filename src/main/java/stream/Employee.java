package stream;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    private int id;
    private String name;
    private String role;
    private double salary;

    // Constructor
    public Employee(int id, String name, String role, double salary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                '}';
    }

    // Method to generate 20 sample Employee objects
    public static List<Employee> generateSampleEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice Smith", "Developer", 90000));
        employees.add(new Employee(2, "Bob Johnson", "Tester", 75000));
        employees.add(new Employee(3, "Charlie White", "Product Owner", 105000));
        employees.add(new Employee(4, "David Brown", "Product Owner", 80000));
        employees.add(new Employee(5, "Eve Davis", "Architect", 95000));
        employees.add(new Employee(6, "Frank Miller", "Developer", 92000));
        employees.add(new Employee(7, "Grace Lee", "Architect", 130000));
        employees.add(new Employee(8, "Hank Garcia", "Tester", 78000));
        employees.add(new Employee(9, "Isabel Clark", "Developer", 89000));
        employees.add(new Employee(10, "Jack Wilson", "Architect", 100000));
        employees.add(new Employee(11, "Kathy Moore", "Developer", 85000));
        employees.add(new Employee(12, "Liam Taylor", "Data Scientist", 125000));
        employees.add(new Employee(13, "Mia Anderson", "Tester", 86000));
        employees.add(new Employee(14, "Noah Thomas", "Tester", 98000));
        employees.add(new Employee(15, "Olivia Martin", "Product Owner", 103000));
        employees.add(new Employee(16, "Paul Scott", "Architect", 110000));
        employees.add(new Employee(17, "Quincy Hill", "Developer", 94000));
        employees.add(new Employee(18, "Rachel Adams", "Developer", 90000));
        employees.add(new Employee(19, "Sam Green", "Developer", 135000));
        employees.add(new Employee(20, "Tina Campbell", "Tester", 96000));

        return employees;
    }

    public static void main(String[] args) {
        List<Employee> employees = generateSampleEmployees();
        Object result1 = employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(result1);

        Object result = employees.stream().collect(Collectors.groupingBy(Employee::getRole, LinkedHashMap::new,
                Collectors.groupingBy(e-> e.getName().charAt(0),
                        Collectors.mapping(Employee::getName, Collectors.toList()))));
        System.out.println(result);
    }
}





















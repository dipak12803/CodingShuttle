package JAVA_Sem6;
import java.io.*;
import java.util.*;
public class Exp7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employees> employees = new ArrayList<>();
        while (true) {
            System.out.println("Main Menu");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    addEmployee(scanner, employees);
                    break;
                case 2:
                    displayAllEmployees(employees);
                    break;
                case 3:
                    System.out.println("Exiting the System");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }
    private static void addEmployee(Scanner scanner, List<Employees> employees) {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        Employees employee = new Employees(id, name, age, salary);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }
    private static void displayAllEmployees(List<Employees> employees) {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }
        System.out.println("----Report-----");
        for (Employees employee : employees) {
            System.out.println(employee);
        }
        System.out.println("----End of Report-----");
    }
}
class Employees implements Serializable {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employees(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + age + " " + salary;
    }
}


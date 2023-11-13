import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee[name = " + name + ", id = " + id + ",salary = " + calculateSalary() + "] ";
    }
}


class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int workingHours;
    private double hourlyRate;
    private double monthlySalary;


    public PartTimeEmployee(String name, int id, int workingHours, double hourlyRate) {
        super(name, id);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * workingHours;
    }
}


class PayrollSystem {
    private ArrayList<Employee> employeeList;

    PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee addedEmployee) {
        employeeList.add(addedEmployee);
    }

    public void removeEmployee(int id) {
        Employee removedEmployee = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                removedEmployee = employee;
                break;
            }
        }
        if (removedEmployee != null) {
            employeeList.remove(removedEmployee);
        }
    }

    public void displayEmployee() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}


public class Main {


    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee employee1 = new FullTimeEmployee("Alam", 123, 12000);
        PartTimeEmployee employee2 = new PartTimeEmployee("Mehran", 124, 40, 100);
        payrollSystem.addEmployee(employee1);
        payrollSystem.addEmployee(employee2);
        System.out.println("Initial Employee Details");
        payrollSystem.displayEmployee();
        System.out.println("Removing Employee");
        payrollSystem.removeEmployee(123);
        System.out.println("Remaining Employee Details");
        payrollSystem.displayEmployee();
    }
}
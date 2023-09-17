import Employee.Employee;

import java.util.List;

public class EmployeeCollectionsPrinter {
    public static void printEmployeeList(List<Employee> employees){
        System.out.printf("%-20s|%-30s|%-40s|%10s|%4s|%n", "Name", "Position", "Description", "Salary", "Year");
        System.out.println("--------------------------------------------------" +
                "-----------------------------------------------------------");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

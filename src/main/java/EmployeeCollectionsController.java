import Employee.Employee;
import Employee.EmployeePosition;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeCollectionsController {
    public void printYoungestAndOldestEmployeeByEveryPosition(List<Employee> employees){
        var employeePositionListMap = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getPosition,
                        Collectors.toList()
                ));
        for (EmployeePosition employeePosition:employeePositionListMap.keySet()
             ) {
            var employeeList = employeePositionListMap.get(employeePosition);
            Optional<Employee> maxAge = employeeList.stream().min(Comparator.comparingInt((Employee o) -> o.getBirthYear()));
            Optional<Employee> minAge = employeeList.stream().max(Comparator.comparingInt((Employee o) -> o.getBirthYear()));
            System.out.println("Minimal and maximal age for position:"+employeePosition.getName());
            System.out.println("Min:" );
            System.out.println(minAge.get());
            System.out.println("Max:" );
            System.out.println(maxAge.get());
        }
    }

    public void printEmployeesByPositions(List<Employee> employees){
        printPositionEmployeeMap(employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getPosition,
                        Collectors.toList()
                )));
    }

    private void printPositionEmployeeMap( Map<EmployeePosition, List<Employee>> stringListMap){
        for (Map.Entry<EmployeePosition, List<Employee>> entry : stringListMap.entrySet()) {
            EmployeePosition category = entry.getKey();
            List<Employee> employeesInCategory = entry.getValue();
            System.out.println(category.getName());
            EmployeeCollectionsPrinter.printEmployeeList(employeesInCategory);
            System.out.println();
        }
    }
    public void printEmployeesBySalaryCategories(List<Employee> employees){
        float minSalary = (float) employees.stream()
                .mapToDouble(Employee::getSalary)
                .min()
                .orElse(0.0);
        float maxSalary = (float) employees.stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0.0);
        float separator = (maxSalary - minSalary)/3;
        double range1End = minSalary + separator;
        double range2End = range1End + separator;
        Map<String, List<Employee>> salaryMap = employees.stream()
                .collect(Collectors.groupingBy(employee -> {
                    double salary = employee.getSalary();
                    if (salary <= range1End) {
                        return "Low Salary";
                    } else if (salary <= range2End) {
                        return "Medium Salary";
                    } else {
                        return "High Salary";
                    }
                }));
        printSalaryEmployeeMap(salaryMap);
    }

    private void printSalaryEmployeeMap( Map<String, List<Employee>> stringListMap){
        for (Map.Entry<String, List<Employee>> entry : stringListMap.entrySet()) {
            String category = entry.getKey();
            List<Employee> employeesInCategory = entry.getValue();
            System.out.println(category);
            EmployeeCollectionsPrinter.printEmployeeList(employeesInCategory);
            System.out.println();
        }
    }

    public static List<Employee> mergeTwoLists(List<Employee> aEmployeeList,List<Employee> bEmployeeList){
        Set<Employee> aSet = new LinkedHashSet<>(aEmployeeList);
        aSet.addAll(bEmployeeList);
        return new ArrayList<>(aSet);
    }

    public List<Employee> deleteFromListByMinYear(List<Employee> list,int year){
        return list.stream().filter(employee -> { return employee.getBirthYear()>year; }).toList();
    }

}

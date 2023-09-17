package Employee;

import java.util.Date;
import java.util.Objects;

public class Employee {
    private String name;
    private EmployeePosition position;
    private int birthYear;
    private float salary;

    public Employee(String name, EmployeePosition position, float salary, int birthYear) {
        this.name = name;
        this.position = position;
        this.birthYear = birthYear;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%-20s|%-30s|%-40s|%10.2f|%4d|",
                name, position.getName(), position.getDescription(), salary, birthYear);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee that = (Employee) obj;
        return Objects.equals(name, that.name) && Objects.equals(this.position,that.position) &&
                Objects.equals(this.birthYear,that.birthYear) && Objects.equals(this.salary,that.salary);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

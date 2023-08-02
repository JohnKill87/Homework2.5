package pro.sky.alistofemployees;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String secondName;
    private final String lastName;
    private final Integer department;
    private final Integer salary;

    public Employee(String firstName, String secondName, String lastName, Integer department, Integer salary) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.secondName = StringUtils.capitalize(secondName.toLowerCase());
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getSecondName(), employee.getSecondName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getDepartment(), employee.getDepartment()) && Objects.equals(getSalary(), employee.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getSecondName(), getLastName(), getDepartment(), getSalary());
    }
}

package pro.sky.alistofemployees;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String secondName;
    private final String lastName;
    private final String yearOfBirth;

    public Employee(String firstName, String secondName, String lastName, String yearOfBirth) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
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

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return "Сотрудник : " + "Имя - " + firstName + '\'' + ", Фамилия - " + lastName + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getSecondName(), employee.getSecondName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getYearOfBirth(), employee.getYearOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getSecondName(), getLastName(), getYearOfBirth());
    }
}

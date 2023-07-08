package pro.sky.alistofemployees;

import org.springframework.stereotype.Service;
import pro.sky.alistofemployees.exceptions.EmployeeAlreadyAddedException;
import pro.sky.alistofemployees.exceptions.EmployeeNotFoundException;
import pro.sky.alistofemployees.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Nosatov", "Aleksey"),
            new Employee("Alexander", "Sergey"),
            new Employee("Gramov", "Grigory"),
            new Employee("Kopytkin", "Ruslan"),
            new Employee("Rumin", "Vladislav"),
            new Employee("Yankin", "Ilya"),
            new Employee("Romanov", "Boris"),
            new Employee("Yukutova", "Natalia"),
            new Employee("Lomara", "Lyudmila"),
            new Employee("Bragina", "Anastasia")
    ));
    private final static int employeesListSize = 11;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee addedEmployee = new Employee(firstName, lastName);
                if (employees.contains(addedEmployee)) {
                throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
            } else if (employees.size() >= employeesListSize){
                throw new EmployeeStorageIsFullException("Список сотрудников переполнен");
            }
        employees.add(addedEmployee);
        return addedEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee removedEmployee = new Employee(firstName, lastName);
            if (employees.remove(removedEmployee)) {
                return removedEmployee;
            } else {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }
    }

    @Override
    public String findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                final String employeeDescription = ""
                        + employee.getFirstName() + " "
                        + employee.getLastName();
                return employeeDescription;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public List<Employee> aListOfEmployees() {
        return employees;
    }
}

package pro.sky.alistofemployees;

import org.springframework.stereotype.Service;
import pro.sky.alistofemployees.exceptions.EmployeeAlreadyAddedException;
import pro.sky.alistofemployees.exceptions.EmployeeNotFoundException;
import pro.sky.alistofemployees.exceptions.EmployeeStorageIsFullException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees = new HashMap<>(Map.of(
            "1978",
            new Employee("Носатов", "Алексей", "Юрьевич", "1978"),
            "1988",
            new Employee("Александр", "Сергей", "Иванович", "1988"),
            "1967",
            new Employee("Грамов", "Григорий", "Иванович", "1967"),
            "1970",
            new Employee("Копыткин", "Руслан", "Александрович", "1970"),
            "2005",
            new Employee("Румин", "Владислав", "Алексеевич", "2005"),
            "1998",
            new Employee("Янкин", "Илья", "Александрович", "1998"),
            "2001",
            new Employee("Романов", "Борис", "Николаевич", "2001"),
            "1997",
            new Employee("Юкутова", "Наталья", "Анатольевна", "1997"),
            "2000",
            new Employee("Ломара", "Людмила", "Ивановна", "2000"),
            "2007",
            new Employee("Брагина", "Анастасия", "Людмиловна", "2007")
    ));
    private final static int employeesListSize = 11;

    @Override
    public Employee addEmployee(String firstName, String secondName, String lastName, String yearOfBorn) {
        Employee addedEmployee = new Employee(firstName, secondName, lastName, yearOfBorn);
        if (employees.equals(addedEmployee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        } else if (employees.size() >= employeesListSize){
            throw new EmployeeStorageIsFullException("Список сотрудников переполнен");
        }
        employees.put(addedEmployee.getYearOfBirth(), addedEmployee);
        return addedEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String secondName, String lastName, String yearOfBorn) {
        Employee removedEmployee = new Employee(firstName, secondName, lastName, yearOfBorn);
            if (employees.remove(removedEmployee.getYearOfBirth(), removedEmployee)) {
                return removedEmployee;
            } else {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }
    }

    @Override
    public String findEmployee(String yearOfBorn) {
        final Employee employee = employees.get(yearOfBorn);
        if (employee == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        final String employeeDescription = ""
                + employee.getFirstName() + " "
                + employee.getSecondName() + " "
                + employee.getLastName() + " "
                + employee.getYearOfBirth();
        return employeeDescription;
    }

    @Override
    public Map<String, Employee> aListOfEmployees() {
        return employees;
    }
}

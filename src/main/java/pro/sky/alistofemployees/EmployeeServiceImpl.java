package pro.sky.alistofemployees;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.alistofemployees.exceptions.EmployeeAlreadyAddedException;
import pro.sky.alistofemployees.exceptions.EmployeeNotFoundException;
import pro.sky.alistofemployees.exceptions.EmployeeStorageIsFullException;
import pro.sky.alistofemployees.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(

            new Employee("Носатов", "Алексей", "Юрьевич",1, 30_000),

            new Employee("Александр", "Сергей", "Иванович",2, 45_000),

            new Employee("Грамов", "Григорий", "Иванович", 3, 65_000),

            new Employee("Копыткин", "Руслан", "Александрович",4, 75_000),

            new Employee("Румин", "Владислав", "Алексеевич",5, 40_000),

            new Employee("Янкин", "Илья", "Александрович",1, 50_000),

            new Employee("Романов", "Борис", "Николаевич",2, 80_000),

            new Employee("Юкутова", "Наталья", "Анатольевна",3, 35_000),

            new Employee("Ломара", "Людмила", "Ивановна",4, 60_000),

            new Employee("Брагина", "Анастасия", "Людмиловна",5, 90_000)
    ));

    private final static int employeesListSize = 11;

    @Override
    public Employee addEmployee(String firstName, String secondName, String lastName, Integer department, Integer salary) {

        if (!validateInput(firstName, secondName, lastName)) {
            throw new InvalidInputException();
        }

        Employee addedEmployee = new Employee(firstName,  secondName, lastName, department, salary);
        if (employees.contains(addedEmployee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        } else if (employees.size() >= employeesListSize){
            throw new EmployeeStorageIsFullException("Список сотрудников переполнен");
        }
        employees.add(addedEmployee);
        return addedEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String secondName, String lastName, Integer department, Integer salary) {

        if (!validateInput(firstName, secondName, lastName)) {
            throw new InvalidInputException();
        }

        Employee removedEmployee = new Employee(firstName, secondName, lastName, department, salary);
        if (employees.remove(removedEmployee)) {
            return removedEmployee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    @Override
    public String findEmployee(String firstName, String secondName, String lastName, Integer department, Integer salary) {

        if (!validateInput(firstName, secondName, lastName)) {
            throw new InvalidInputException();
        }

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

    private boolean validateInput(String firstName, String secondName, String lastName) {
        return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(secondName) && StringUtils.isAlpha(lastName);
    }
}

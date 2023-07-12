package pro.sky.alistofemployees;

import pro.sky.alistofemployees.exceptions.EmployeeAlreadyAddedException;
import pro.sky.alistofemployees.exceptions.EmployeeStorageIsFullException;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(String firstName, String secondName, String lastName, String yearOfBorn);

    Employee removeEmployee(String firstName, String secondName, String lastName, String yearOfBorn);

    String findEmployee(String yearOfBorn);

    Map<String, Employee> aListOfEmployees();
}

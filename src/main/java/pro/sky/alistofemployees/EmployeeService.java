package pro.sky.alistofemployees;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String firstName, String secondName, String lastName, Integer department, Integer salary);

    Employee removeEmployee(String firstName, String secondName, String lastName, Integer department, Integer salary);

    String findEmployee(String firstName, String secondName, String lastName, Integer department, Integer salary);

    List<Employee> aListOfEmployees();

}

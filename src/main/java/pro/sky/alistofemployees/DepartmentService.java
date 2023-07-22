package pro.sky.alistofemployees;

import org.springframework.stereotype.Service;
import pro.sky.alistofemployees.exceptions.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //        (Сотрудник с минимальной зарплатой)
    public Employee employeeWithMinSalary(Integer department) {
     return employeeService.aListOfEmployees().stream()
             .filter(employee -> employee.getDepartment() == department)
             .min(Comparator.comparingInt(Employee::getSalary))
             .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник с минимальной зарплатой не найден"));
    }

    public Employee employeeWithMaxSalary(Integer department) {
        return employeeService.aListOfEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник с максимальной зарплатой не найден"));
    }

    public Map<Integer, List<Employee>> findEmployeeByDepartment(Integer department) {
        return employeeService.aListOfEmployees().stream()
                .filter(e -> department == null || e.getDepartment() == department)
                .collect(groupingBy(Employee::getDepartment, toList()));
    }
}

package pro.sky.alistofemployees;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @ExceptionHandler({RuntimeException.class})
    public String handleException(Exception e) {
        return  e.getMessage();
    }
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) { this.employeeService = employeeService; }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("secondName") String secondName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("department") int department,
                                @RequestParam("salary") int salary) {
        return employeeService.removeEmployee(firstName, secondName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("secondName") String secondName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("department") int department,
                                   @RequestParam("salary") int salary) {
        return employeeService.removeEmployee(firstName, secondName, lastName, department, salary);
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("secondName") String secondName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("department") int department,
                               @RequestParam("salary") int salary) {
        return employeeService.findEmployee(firstName, secondName, lastName, department, salary);
    }

    @GetMapping()
    public List<Employee> aListOfEmployees() {
        return employeeService.aListOfEmployees();
    }
}

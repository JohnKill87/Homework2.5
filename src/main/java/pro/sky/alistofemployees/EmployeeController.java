package pro.sky.alistofemployees;

import org.springframework.web.bind.annotation.*;

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
                                @RequestParam("yearOfBorn") String yearOfBorn
                              ) {
        return  employeeService.addEmployee(firstName, secondName, lastName, yearOfBorn);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("secondName") String secondName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("yearOfBorn") String yearOfBorn) {
        return employeeService.removeEmployee(firstName, secondName, lastName, yearOfBorn);
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("yearOfBorn") String yearOfBorn) {
        return employeeService.findEmployee(yearOfBorn);
    }

    @GetMapping()
    public Map<String, Employee> aListOfEmployees() {
        return employeeService.aListOfEmployees();
    }
}

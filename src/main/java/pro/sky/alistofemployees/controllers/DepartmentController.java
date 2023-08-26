package pro.sky.alistofemployees.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.alistofemployees.services.DepartmentService;
import pro.sky.alistofemployees.objects.Employee;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/minSalary")
    public Employee findEmployeeWithMinSalary(@RequestParam Integer department) {
        return departmentService.employeeWithMinSalary(department);
    }

    @GetMapping("/maxSalary")
    public Employee findEmployeeWithMaxSalary(@RequestParam Integer department) {
        return departmentService.employeeWithMaxSalary(department);
    }

    @GetMapping("/all")
    public Map<Integer, List <Employee>> findEmployeeByDepartment(@RequestParam(required = false) Integer department) {
        return departmentService.findEmployeeByDepartment(department);
    }
}

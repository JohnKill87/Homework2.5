package pro.sky.alistofemployees.servicesTests;

import org.junit.jupiter.api.Test;
import pro.sky.alistofemployees.objects.Employee;
import pro.sky.alistofemployees.services.EmployeeServiceImpl;


import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.alistofemployees.generators.EmployeeGenerator.*;

class EmployeeServiceImplTest {

    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Test
    void addEmployee_success() {

//        Входные данные.

        String firstName = IVAN_FIRST_NAME;
        String secondName = IVAN_SECOND_NAME;
        String lastName = IVAN_LAST_NAME;
        int salary = IVAN_SALARY;
        int department = DEPARTMENT_ONE;

//        Ожидаемый результат.

        Employee expected = getIvanDepOne();

//        Тест.

        Employee actual = employeeService.addEmployee(firstName, secondName, lastName, department, salary);

        assertEquals(expected, actual);
    }

    @Test
    void removeEmployee_success() {

//        Входные данные.

        String firstName = IVAN_FIRST_NAME;
        String secondName = IVAN_SECOND_NAME;
        String lastName = IVAN_LAST_NAME;
        int salary = IVAN_SALARY;
        int department = DEPARTMENT_ONE;

//        Тест.

        assertThrows(RuntimeException.class, () -> employeeService.removeEmployee(firstName, secondName, lastName, department, salary));
    }

    @Test
    void findEmployee_success() {

//        Входные данные.

        String firstName = IVAN_FIRST_NAME;
        String secondName = IVAN_SECOND_NAME;
        String lastName = IVAN_LAST_NAME;
        int salary = IVAN_SALARY;
        int department = DEPARTMENT_ONE;

//        Ожидаемый результат.

        employeeService.addEmployee(firstName, secondName, lastName, department, salary);
        String expected = employeeService.findEmployee(firstName, secondName, lastName, department, salary);

//        Тест.

        assertEquals(expected, "Иван Иванович");
    }
}
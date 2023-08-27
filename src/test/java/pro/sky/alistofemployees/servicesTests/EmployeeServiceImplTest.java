package pro.sky.alistofemployees.servicesTests;

import org.junit.jupiter.api.Test;
import pro.sky.alistofemployees.exceptions.EmployeeAlreadyAddedException;
import pro.sky.alistofemployees.exceptions.EmployeeNotFoundException;
import pro.sky.alistofemployees.exceptions.EmployeeStorageIsFullException;
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
    void addEmployee_withEmployeeAlreadyAddedException() {

//        Входные данные.

        String firstName = IVAN_FIRST_NAME;
        String secondName = IVAN_SECOND_NAME;
        String lastName = IVAN_LAST_NAME;
        int salary = IVAN_SALARY;
        int department = DEPARTMENT_ONE;

//        Ожидаемый результат.

        employeeService.addEmployee(firstName, secondName, lastName, department, salary);
        String expectedMessage = "Сотрудник уже существует";

//        Тест.

        Exception exception = assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService
                .addEmployee(firstName, secondName, lastName, department, salary));

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void addEmployee_withEmployeeStorageIsFullException() {

//        Входные данные.

        String firstName = IVAN_FIRST_NAME;
        String secondName = IVAN_SECOND_NAME;
        String lastName = IVAN_LAST_NAME;
        int salary = IVAN_SALARY;
        int department = DEPARTMENT_ONE;

//        Ожидаемый результат.

        employeeService.addEmployee(ILYA_FIRST_NAME, ILYA_SECOND_NAME, ILYA_LAST_NAME, DEPARTMENT_ONE, ILYA_SALARY);
        String expectedMessage = "Список сотрудников переполнен";

//        Тест.

        Exception exception = assertThrows(EmployeeStorageIsFullException.class, () -> employeeService
                .addEmployee(firstName, secondName, lastName, department, salary));

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void removeEmployee_withEmployeeNotFoundException() {

//        Входные данные.

        String firstName = IVAN_FIRST_NAME;
        String secondName = IVAN_SECOND_NAME;
        String lastName = IVAN_LAST_NAME;
        int salary = IVAN_SALARY;
        int department = DEPARTMENT_ONE;

//        Тест.

        assertThrows(EmployeeNotFoundException.class, () -> employeeService.
                removeEmployee(firstName, secondName, lastName, department, salary));
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

        String actual = "Иван Иванович";

        assertEquals(expected, actual);
    }

    @Test
    void findEmployee_withEmployeeNotFoundException() {

//        Входные данные.

        String firstName = IVAN_FIRST_NAME;
        String secondName = IVAN_SECOND_NAME;
        String lastName = IVAN_LAST_NAME;
        int salary = IVAN_SALARY;
        int department = DEPARTMENT_ONE;

//        Ожидаемый результат.

        String expectedMessage = "Сотрудник не найден";

//        Тест.

        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> employeeService
                .findEmployee(firstName, secondName, lastName, department, salary));

        assertEquals(expectedMessage, exception.getMessage());
    }
}
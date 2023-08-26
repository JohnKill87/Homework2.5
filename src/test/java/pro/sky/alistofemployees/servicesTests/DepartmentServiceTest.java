package pro.sky.alistofemployees.servicesTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.alistofemployees.exceptions.EmployeeNotFoundException;
import pro.sky.alistofemployees.objects.Employee;
import pro.sky.alistofemployees.services.DepartmentService;
import pro.sky.alistofemployees.services.EmployeeService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pro.sky.alistofemployees.generators.EmployeeGenerator.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;


    @InjectMocks
    private DepartmentService departmentService;

    @Test
    void employeeWithMinSalary_Success() {

//        Входные данные.

        int department = DEPARTMENT_ONE;

//        Ожидаемый результат.

        Employee expected = getIvanDepOne();
        Employee ivanDepOne = getIvanDepOne();
        Employee ilyaDepOne = getIlyaDepOne();
        Employee mishaDepTwo = getMishaDepTwo();

        Mockito.when(employeeService.aListOfEmployees())
                .thenReturn(List.of(ivanDepOne, ilyaDepOne, mishaDepTwo));

//        Тест.

        Employee actual = departmentService.employeeWithMinSalary(department);
        assertEquals(expected, actual);
        assertEquals(department, actual.getDepartment());
        assertTrue(ivanDepOne.getSalary() < ilyaDepOne.getSalary());
        verify(employeeService).aListOfEmployees();
    }

    @Test
    void employeeWithMinSalary_EmployeeNotFoundException() {

//        Входные данные.

        int department = DEPARTMENT_ONE;

//        Ожидаемый результат.

        Mockito.when(employeeService.aListOfEmployees())
                .thenReturn(Collections.singletonList(getMishaDepTwo()));

        String expectedMessage = "Сотрудник с минимальной зарплатой не найден";

//        Тест.

        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> departmentService.employeeWithMinSalary(department));
        assertEquals(expectedMessage, exception.getMessage());
        verify(employeeService).aListOfEmployees();
    }

    @Test
    void employeeWithMaxSalary_Success() {

//        Входные данные.

        int department = DEPARTMENT_ONE;

//        Ожидаемый результат.

        Employee expected = getIlyaDepOne();
        Employee ivanDepOne = getIvanDepOne();
        Employee ilyaDepOne = getIlyaDepOne();
        Employee mishaDepTwo = getMishaDepTwo();

        Mockito.when(employeeService.aListOfEmployees())
                .thenReturn(List.of(ivanDepOne, ilyaDepOne, mishaDepTwo));

//        Тест.

        Employee actual = departmentService.employeeWithMaxSalary(department);
        assertEquals(expected, actual);
        assertEquals(department, actual.getDepartment());
        assertTrue(ivanDepOne.getSalary() < ilyaDepOne.getSalary());
        verify(employeeService).aListOfEmployees();
    }

    @Test
    void employeeWithMaxSalary_EmployeeNotFoundException() {

//        Входные данные.

        int department = DEPARTMENT_ONE;

//        Ожидаемый результат.

        Mockito.when(employeeService.aListOfEmployees())
                .thenReturn(Collections.singletonList(getMishaDepTwo()));

        String expectedMessage = "Сотрудник с максимальной зарплатой не найден";

//        Тест.

        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> departmentService.employeeWithMaxSalary(department));
        assertEquals(expectedMessage, exception.getMessage());
        verify(employeeService).aListOfEmployees();
    }

    @Test
    void findEmployeeByDepartment_Success() {

//        Входные данные.

        Integer department = DEPARTMENT_ONE;

//        Ожидаемый результат.

        Employee ivanDepOne = getIvanDepOne();
        Employee ilyaDepOne = getIlyaDepOne();
        Employee mishaDepTwo = getMishaDepTwo();

        Mockito.when(employeeService.aListOfEmployees())
                .thenReturn(List.of(ivanDepOne, ilyaDepOne, mishaDepTwo));

        Map<Integer, List<Employee>> expected = new HashMap<>();
        expected.put(department, List.of(ivanDepOne, ilyaDepOne));

//        Тест.

        Map<Integer, List<Employee>> actual = departmentService.findEmployeeByDepartment(department);
        assertEquals(expected, actual);
        verify(employeeService).aListOfEmployees();
    }

    @Test
    void findEmployeeByDepartment_WithNullDep() {

//        Входные данные.

        Integer department = null;

//        Ожидаемый результат.

        Employee ivanDepOne = getIvanDepOne();
        Employee ilyaDepOne = getIlyaDepOne();
        Employee mishaDepTwo = getMishaDepTwo();

        Mockito.when(employeeService.aListOfEmployees())
                .thenReturn(List.of(ivanDepOne, ilyaDepOne, mishaDepTwo));

        Map<Integer, List<Employee>> expected = new HashMap<>();
        expected.put(DEPARTMENT_ONE, List.of(ivanDepOne, ilyaDepOne));
        expected.put(DEPARTMENT_TWO, List.of(mishaDepTwo));

//        Тест.

        Map<Integer, List<Employee>> actual = departmentService.findEmployeeByDepartment(department);
        assertEquals(expected, actual);
        verify(employeeService).aListOfEmployees();
    }
}
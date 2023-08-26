package pro.sky.alistofemployees.generators;

import pro.sky.alistofemployees.objects.Employee;

public class EmployeeGenerator {
    public static final String IVAN_FIRST_NAME = "Иван";
    public static final String IVAN_SECOND_NAME = "Иванов";
    public static final String IVAN_LAST_NAME = "Иванович";
    public static final  int IVAN_SALARY = 10_000;

    public static final  int DEPARTMENT_ONE = 1;
    public static final  int DEPARTMENT_TWO = 2;

    public static Employee getIvanDepOne() {
        return new Employee(IVAN_FIRST_NAME, IVAN_SECOND_NAME, IVAN_LAST_NAME, DEPARTMENT_ONE, IVAN_SALARY);
    }

    public static final String ILYA_FIRST_NAME = "Илья";
    public static final String ILYA_SECOND_NAME = "Ильич";
    public static final String ILYA_LAST_NAME = "Ильинович";
    public static final  int ILYA_SALARY = 20_000;

    public static Employee getIlyaDepOne() {
        return new Employee(ILYA_FIRST_NAME, ILYA_SECOND_NAME, ILYA_LAST_NAME, DEPARTMENT_ONE, ILYA_SALARY);
    }

    public static final String MISHA_FIRST_NAME = "Миша";
    public static final String MISHA_SECOND_NAME = "Михаил";
    public static final String MISHA_LAST_NAME = "Михаилович";
    public static final  int MISHA_SALARY = 15_000;

    public static Employee getMishaDepTwo() {
        return new Employee(MISHA_FIRST_NAME, MISHA_SECOND_NAME, MISHA_LAST_NAME, DEPARTMENT_TWO, MISHA_SALARY);
    }

}

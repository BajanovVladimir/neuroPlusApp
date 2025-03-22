package ru.bazhanov.employees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.bazhanov.project.employees.dto.EmployeeDTO;
import ru.bazhanov.project.employees.service.EmployeesService;

@SpringBootTest
public class EmployeeServiceImplTests {
    @Autowired
    private EmployeesService employeesService;

    @Test
    public void test_that_save_is_OK(){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Employee1");
        int size = employeesService.getAllEmployees().size();
        employeesService.save(employeeDTO);
        int sizeNew = employeesService.getAllEmployees().size();
        Assertions.assertEquals(size+1, sizeNew );
    }

    @Test
    public void test_that_not_save_if_employeeDTO_is_empty(){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        int size = employeesService.getAllEmployees().size();
        Assertions.assertFalse(employeesService.save(employeeDTO));
        int sizeNew = employeesService.getAllEmployees().size();
        Assertions.assertEquals(size, sizeNew );
    }

}

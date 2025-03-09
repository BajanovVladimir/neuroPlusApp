package ru.bazhanov.project.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bazhanov.project.employees.dto.EmployeeDTO;
import ru.bazhanov.project.model.Employee;
import ru.bazhanov.project.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Boolean save(EmployeeDTO employeeDTO) {
        if(employeeDTO == null || employeeDTO.getName() == null){
            return false;
        }
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        if(employeeRepository.save(employee) == null){
            return  false;
        }
        return true;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public List<Employee> getCurrentEmployees() {
        return null;
    }

    @Override
    public Boolean deleteById(int employeeId) {
        return null;
    }
}

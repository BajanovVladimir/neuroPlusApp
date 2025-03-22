package ru.bazhanov.project.employees.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bazhanov.project.employees.dto.EmployeeDTO;
import ru.bazhanov.project.model.Employee;
import ru.bazhanov.project.model.OurService;
import ru.bazhanov.project.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeesServiceImpl implements EmployeesService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Boolean save(EmployeeDTO employeeDTO) {
        if(employeeDTO.getName() == null){
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
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getCurrentEmployees() {
        return getAllEmployees().stream()
                .filter(o -> (o.getDeleted() == false))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(int employeeId) {
        try {
            Employee employee = getById(employeeId);
            employee.setDeleted(true);
            employeeRepository.save(employee);
            return true;
        } catch (EntityNotFoundException e){
            return false;
        }
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.getReferenceById(id);
    }
}

package ru.bazhanov.project.employees.service;

import ru.bazhanov.project.employees.dto.EmployeeDTO;
import ru.bazhanov.project.model.Employee;

import java.util.List;

public interface EmployeesService {
   Boolean save(EmployeeDTO employee);
   List<Employee> getAllEmployees();
   List<Employee> getCurrentEmployees();
   Boolean deleteById(int employeeId);
   Employee getById(int id);
   Boolean serviceAddById(int employeeId, int serviceId);
   Boolean serviceRemoveById(int employeeId, int serviceId);
}

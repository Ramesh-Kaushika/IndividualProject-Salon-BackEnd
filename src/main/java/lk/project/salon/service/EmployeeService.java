package lk.project.salon.service;

import lk.project.salon.dto.EmployeeDto;
import lk.project.salon.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Object saveEmployee(EmployeeDto employeeDto);

    String deleteEmployee(Integer id);

    List<Employee> getAllEmployee();

    Object updateEmployee(Integer id, EmployeeDto employeeDto);

}

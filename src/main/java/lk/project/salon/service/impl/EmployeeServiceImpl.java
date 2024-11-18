package lk.project.salon.service.impl;

import lk.project.salon.dto.EmployeeDto;
import lk.project.salon.entity.Employee;
import lk.project.salon.repo.EmployeeRepo;
import lk.project.salon.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {


   private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Object saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getEmployeeId(),
                employeeDto.getEmployeeName(),
                employeeDto.getPosition(),
                employeeDto.getEmail(),
                employeeDto.getPhoneNumber(),
                employeeDto.getEmployeeSalary()
        );
        return employeeRepo.save(employee);
    }

    @Override
    public String deleteAdmin(Integer id) {
        if (employeeRepo.existsById(id)){
            employeeRepo.deleteById(id);
            return "Employee Deleted";
        }
        return "No employee Found";
    }
}

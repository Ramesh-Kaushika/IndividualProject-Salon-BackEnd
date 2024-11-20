package lk.project.salon.controller;

import lk.project.salon.dto.AdminDto;
import lk.project.salon.dto.EmployeeDto;
import lk.project.salon.entity.Employee;
import lk.project.salon.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeDto employeeDto){
        Object newEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllEmployee(){
        List<Employee> allEmployee = employeeService.getAllEmployee();
        return new ResponseEntity<>(allEmployee, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto){
        Object employee = employeeService.updateEmployee(id, employeeDto );
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable Integer id){
        String deleted = employeeService.deleteEmployee(id);
        return new ResponseEntity<>(deleted, HttpStatus.CREATED);
    }

}

package lk.project.salon.controller;

import lk.project.salon.dto.EmployeeDto;
import lk.project.salon.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable Integer id){
        String deleted = employeeService.deleteAdmin(id);
        return new ResponseEntity<>(deleted, HttpStatus.CREATED);
    }

}
